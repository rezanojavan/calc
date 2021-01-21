package com.airwallex.app.calc.service;

import com.airwallex.app.calc.common.exception.ArithmeticException;
import com.airwallex.app.calc.common.exception.InvalidInputException;
import com.airwallex.app.calc.common.exception.OperationNotSupportedException;
import org.apiguardian.api.API;

import java.util.List;

/**
 * Calculator service that provide standard functionality to outer word
 *
 * @author Reza Nojavan
 */
@API(status = API.Status.EXPERIMENTAL)
public interface CalculatorService {

    /**
     * Accept new input to calculator engine
     *
     * @param input new input
     * @return latest state after input applied
     * @throws InvalidInputException if input is not valid
     * @throws ArithmeticException   if any error happening during executing operators
     * @throws OperationNotSupportedException if unsupported operation passed
     */
    String acceptInput(String input) throws InvalidInputException, ArithmeticException, OperationNotSupportedException;

    /**
     * Accept new inputs to calculator engine
     *
     * @param inputs new inputs
     * @return latest state after inputs applied
     * @throws InvalidInputException if input is not valid
     * @throws ArithmeticException   if any error happening during executing operators
     * @throws OperationNotSupportedException if unsupported operation passed
     */
    String acceptInput(List<String> inputs) throws InvalidInputException, ArithmeticException, OperationNotSupportedException;

    /**
     * Get result of calculation
     *
     * @return result
     */
    String getResult();
}
