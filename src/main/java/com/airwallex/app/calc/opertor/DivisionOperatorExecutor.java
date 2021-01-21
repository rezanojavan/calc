package com.airwallex.app.calc.opertor;

import com.airwallex.app.calc.common.exception.InvalidInputException;
import com.airwallex.app.calc.common.util.NumberUtil;

/**
 * This class execute division operator
 *
 * @author Reza Nojavan
 * @version 1.0-SNAPSHOT
 */
public class DivisionOperatorExecutor implements OperatorExecutor {
    @Override
    public String execute(String... input) throws InvalidInputException, ArithmeticException {
        if (input == null || input.length < 2)
            throw new InvalidInputException("Not enough input. At least two input should be provided");
        return NumberUtil.format15Decimal(convert(input[0]) / convert(input[1]));
    }

    /**
     * This method convert an string to Double
     *
     * @param input to convert
     * @return converted Double
     * @throws InvalidInputException in input is not valid
     */
    private Double convert(String input) throws InvalidInputException {
        try {
            return Double.valueOf(input);
        } catch (NumberFormatException ex) {
            throw new InvalidInputException(String.format("input %s is not a number", input));
        }
    }

    @Override
    public String operation() {
        return "/";
    }

    @Override
    public int requiredInputCount() {
        return 2;
    }
}
