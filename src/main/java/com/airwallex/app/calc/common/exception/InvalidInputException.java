package com.airwallex.app.calc.common.exception;

/**
 * Invalid input exception that represent an invalid input found
 *
 * @author Reza Nojavan
 * @version 1.0-rc
 */
public class InvalidInputException extends Exception {

    /**
     * Initiate an {@code InvalidInputException} by given message
     *
     * @param message exception description
     */
    public InvalidInputException(String message) {
        super(message);
    }
}
