package com.airwallex.app.calc.operation;

import com.airwallex.app.calc.common.exception.OperationNotSupportedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apiguardian.api.API;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class return appropriate operation implementation
 *
 * @author Reza
 */
@API(status = API.Status.EXPERIMENTAL)
public class OperationFactory {

    /**
     * Hold a collection of operations
     */
    public static Map<String, OperationExecutor> operationExecutor = new HashMap<>();

    /**
     * Logger
     */
    private static final Logger logger = LogManager.getLogger();

    /**
     * Get a operation executor
     *
     * @param operation to get
     * @return operation executor
     * @throws OperationNotSupportedException if operation not supported yet
     */
    public OperationExecutor getOperationExecutor(String operation) throws OperationNotSupportedException {
        OperationExecutor operationExecutor = OperationFactory.operationExecutor.get(operation);
        if (operationExecutor == null) {
            throw new OperationNotSupportedException(String.format("operation %s not supported", operation));
        }
        return operationExecutor;
    }

    /**
     * This method initiate {@code OperationFactory}. This will read all implementation of {@code OperationExecutor}
     * in same package and create a new instance of them and put instances into {@code operationExecutor} map
     */
    private static void init() {
        Reflections reflections = new Reflections(OperationFactory.class.getPackageName());
        Set<Class<? extends OperationExecutor>> allOperationExecutors =
                reflections.getSubTypesOf(OperationExecutor.class);
        for (Class<? extends OperationExecutor> operationExecutorClass : allOperationExecutors ){
            try {
                OperationExecutor instance = operationExecutorClass.getDeclaredConstructor().newInstance();
                OperationFactory.operationExecutor.put(instance.operation(), instance);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                    | InvocationTargetException ex) {
                logger.error("Operation {} failed to create", operationExecutorClass.getSimpleName(), ex);
            }
        }
    }

    static {
        //init factory
        init();
    }
}
