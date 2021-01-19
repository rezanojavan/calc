package com.airwallex.app.calc.operation;

import com.airwallex.app.calc.common.exception.InvalidInputException;
import org.apiguardian.api.API;

/**
 * Operation specification that all operation should implement this specification. The implementations of this
 * specification should be take of their object state because object instances will be share among all statements.
 * In other word implementation should be stateless
 *
 * @author Reza Nojavan
 */
@API(status = API.Status.EXPERIMENTAL)
public interface OperationExecutor {

    /**
     * This method execute operation and return result
     *
     * @param input to execute operation
     * @return result
     * @throws InvalidInputException if invalid input passed
     * @throws ArithmeticException   if any error happened
     */
    String execute(String... input) throws InvalidInputException, ArithmeticException;

    /**
     * Get operation that this executor can execute
     *
     * @return operation
     */
    String operation();

    /**
     * This method represent how many input required to execute this operation. for example for + operation this method
     * will return 2
     *
     * @return input count
     */
    int requiredInputCount();

}
