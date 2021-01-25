package com.airwallex.app.calc.opertor;

import com.airwallex.app.calc.common.exception.OperationNotSupportedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apiguardian.api.API;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

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
public class OperatorFactory {

    /**
     * Hold a collection of operations
     */
    public final static Map<String, OperatorExecutor> operationExecutor = new HashMap<>();

    /**
     * Logger
     */
    private static final Logger logger = LogManager.getLogger();

    /**
     * Get a operator executor
     *
     * @param operator to get
     * @return operator executor
     * @throws OperationNotSupportedException if operation not supported yet
     */
    public static OperatorExecutor getOperatorExecutor(String operator) throws OperationNotSupportedException {
        OperatorExecutor operatorExecutor = OperatorFactory.operationExecutor.get(operator);
        if (operatorExecutor == null) {
            throw new OperationNotSupportedException(String.format("operation %s not supported", operator));
        }
        return operatorExecutor;
    }

    /**
     * This method initiate {@code OperationFactory}. This will read all implementation of {@code OperationExecutor}
     * in same package and create a new instance of them and put instances into {@code operationExecutor} map
     */
    private static void init() {
        Reflections reflections = new Reflections(OperatorFactory.class.getPackageName(), new SubTypesScanner(false));
        Set<Class<? extends OperatorExecutor>> allOperationExecutors =
                reflections.getSubTypesOf(OperatorExecutor.class);
        for (Class<? extends OperatorExecutor> operationExecutorClass : allOperationExecutors ){
            try {
                OperatorExecutor instance = operationExecutorClass.getDeclaredConstructor().newInstance();
                OperatorFactory.operationExecutor.put(instance.operation(), instance);
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
