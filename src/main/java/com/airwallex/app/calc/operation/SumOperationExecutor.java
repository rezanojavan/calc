package com.airwallex.app.calc.operation;

import com.airwallex.app.calc.common.exception.InvalidInputException;

/**
 * This class executor sum operation
 *
 * @author Reza Nojavan
 * @version 1.0-SNAPSHOT
 */
public class SumOperationExecutor implements OperationExecutor {
    @Override
    public String execute(String... input) throws InvalidInputException, ArithmeticException {
        if (input == null || input.length < 2)
            throw new InvalidInputException("Not enough input. At least two parameters should be provided");
        double result = 0D;
        for (String operand : input) {
            try {
                result += Double.valueOf(operand);
            } catch (NumberFormatException ex) {
                throw new InvalidInputException(String.format("input %s is not a number", operand));
            }
        }
        return String.valueOf(result);
    }

    @Override
    public String operation() {
        return "+";
    }

    @Override
    public int requiredInputCount() {
        return 2;
    }
}
