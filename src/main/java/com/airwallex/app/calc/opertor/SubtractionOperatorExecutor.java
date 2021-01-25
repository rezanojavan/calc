package com.airwallex.app.calc.opertor;

import com.airwallex.app.calc.common.exception.InvalidInputException;
import com.airwallex.app.calc.common.util.NumberUtil;

/**
 * This class execute subtraction operator
 *
 * @author Reza Nojavan
 * @version 1.0-SNAPSHOT
 */
public class SubtractionOperatorExecutor implements OperatorExecutor {
    @Override
    public String execute(String... input) throws InvalidInputException, ArithmeticException {
        if (input == null || input.length < 2)
            throw new InvalidInputException("Not enough input. At least two input should be provided");
        return NumberUtil.format15Decimal(NumberUtil.convert(input[0]) - NumberUtil.convert(input[1]));
    }

    @Override
    public String operation() {
        return "-";
    }

    @Override
    public int requiredInputCount() {
        return 2;
    }
}
