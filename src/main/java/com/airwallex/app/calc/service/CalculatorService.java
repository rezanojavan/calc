package com.airwallex.app.calc.service;

import com.airwallex.app.calc.common.exception.InvalidInputException;
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
     * @return a list of string that present latest state after input applied
     * @throws InvalidInputException if input is not valid
     * @throws ArithmeticException   if any error happening during executing operators
     */
    List<String> acceptInput(String input) throws InvalidInputException, ArithmeticException;

    /**
     * Accept new inputs to calculator engine
     *
     * @param inputs new inputs
     * @return a list of string that present latest state after inputs applied
     * @throws InvalidInputException if input is not valid
     * @throws ArithmeticException   if any error happening during executing operators
     */
    List<String> acceptInput(List<String> inputs) throws InvalidInputException, ArithmeticException;

    /**
     * Get result of calculation
     *
     * @return result
     */
    List<String> getResult();
}
