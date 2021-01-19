package com.airwallex.app.calc.common.exception;

/**
 * This exception represent that operation not supported currently
 *
 * @author Reza Nojavan
 * @version 1.0-SNAPSHOT
 */
public class OperationNotSupportedException extends Exception {

    /**
     * initiate exception by given message
     *
     * @param message to initiate exception
     */
    public OperationNotSupportedException(String message) {
        super(message);
    }
}
