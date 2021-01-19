package com.airwallex.app.calc.common.validator;

import com.airwallex.app.calc.common.exception.InvalidInputException;
import com.airwallex.app.calc.common.util.StringUtil;
import com.airwallex.app.calc.operation.OperationFactory;

import java.util.List;

/**
 * This class will check input to make sure it is a digit or a supported operation otherwise will throw an input
 * validation exception
 *
 * @author Reza Nojavan
 * @version 1.0-SNAPSHOT
 */
public class InputValidator {

    /**
     * Validating input
     *
     * @param inputs to validate
     */
    public void isValid(List<String> inputs) throws InvalidInputException {
        for (String input : inputs)
            isValid(input);
    }

    /**
     * Validating input
     *
     * @param input to validate
     */
    public void isValid(String input) throws InvalidInputException {
        if (!StringUtil.isDigit(input) && !isSupportedOperation(input))
            throw new InvalidInputException(String.format("Value %s is not valid", input));
    }



    /**
     * This method checks input is a supported operation or not
     *
     * @param input to check
     * @return true if so otherwise false
     */
    private boolean isSupportedOperation(String input) {
        return OperationFactory.operationExecutor.containsKey(input);
    }


}
