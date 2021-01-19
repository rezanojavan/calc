package com.airwallex.app.calc.common.validator;

import com.airwallex.app.calc.common.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * InputValidation test
 *
 * @author Reza Nojavan
 */
class InputValidatorTest {

    /**
     * Validator
     */
    private InputValidator inputValidator = new InputValidator();

    @Test
    void isValid() throws InvalidInputException {
        inputValidator.isValid(Arrays.asList("1.1", "1"));

    }

    @Test
    void operationIsNotValid(){
        Assertions.assertThrows(InvalidInputException.class, () -> inputValidator.isValid(Arrays.asList("1", "xx")));
    }


}