package com.airwallex.app.calc.common.exception;

/**
 * Arithmetic exception that represent an exception occurred when executing operations
 *
 * @author Reza Nojavan
 * @version 1.0-rc
 */
public class ArithmeticException extends Exception {

    /**
     * Initiate exception by given message
     *
     * @param message to initiate exception
     */
    public ArithmeticException(String message) {
        super(message);
    }
}
