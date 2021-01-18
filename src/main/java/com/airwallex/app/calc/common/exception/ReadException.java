package com.airwallex.app.calc.common.exception;

/**
 * Read Exception that represent something went wrong when reading input
 *
 * @author Reza Nojavan
 * @version 1.0-SNAPSHOT
 */
public class ReadException extends Exception {

    /**
     * initiate exception by given message
     *
     * @param message to initiate exception
     */
    public ReadException(String message) {
        super(message);
    }

    /**
     * initiate exception by given message and cause
     *
     * @param message to initiate exception
     * @param cause   to initiate exception
     */
    public ReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
