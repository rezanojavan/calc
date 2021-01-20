package com.airwallex.app.calc.opertor;

import com.airwallex.app.calc.common.exception.InvalidInputException;
import com.airwallex.app.calc.common.util.NumberUtil;

/**
 * This class execute sum operator
 *
 * @author Reza Nojavan
 * @version 1.0-SNAPSHOT
 */
public class AdditionOperatorExecutor implements OperatorExecutor {
    @Override
    public String execute(String... input) throws InvalidInputException, ArithmeticException {
        if (input == null || input.length < 2)
            throw new InvalidInputException("Not enough input. At least two input should be provided");
        double result = 0D;
        for (String operand : input) {
            try {
                result += Double.valueOf(operand);
            } catch (NumberFormatException ex) {
                throw new InvalidInputException(String.format("input %s is not a number", operand));
            }
        }
        return NumberUtil.format15Decimal(result);
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
