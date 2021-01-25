package com.airwallex.app.calc.opertor;

import com.airwallex.app.calc.common.exception.InvalidInputException;
import com.airwallex.app.calc.common.util.NumberUtil;

/**
 * This class execute sqrt operator
 *
 * @author Reza Nojavan
 * @version 1.0-rc
 */
public class SqrtOperatorExecutor implements OperatorExecutor {
    @Override
    public String execute(String... input) throws InvalidInputException, ArithmeticException {
        if (input == null || input.length == 0)
            throw new InvalidInputException("Not enough input. At least 1 input should be provided");
        if (input.length > 1)
            throw new InvalidInputException("too many input. At last 1 input should be provided");
        try {
            return NumberUtil.format15Decimal(Math.sqrt(Double.valueOf(input[0])));
        } catch (NumberFormatException ex) {
            throw new InvalidInputException(String.format("input %s is not a number", input[0]));
        }

    }

    @Override
    public String operation() {
        return "sqrt";
    }

    @Override
    public int requiredInputCount() {
        return 1;
    }
}
