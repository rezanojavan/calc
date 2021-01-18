package com.airwallex.app.calc.input;

import com.airwallex.app.calc.common.exception.ReadException;

import java.util.List;

/**
 * The standard implementation for input processor. This interface expose standard operation of input for outer word
 *
 * @author Reza Nojavan
 * @version 1.0-SNAPSHOT
 */
public interface InputProcessor {

    /**
     * This method read from input and return input as a {@code List} of string
     *
     * @return list of string
     * @throws ReadException if any
     */
    List<String> read() throws ReadException;
}
