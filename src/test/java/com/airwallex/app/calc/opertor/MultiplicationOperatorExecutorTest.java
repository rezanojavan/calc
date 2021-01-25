package com.airwallex.app.calc.opertor;

import com.airwallex.app.calc.common.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Multiplication operator unit test
 *
 * @author Reza Nojavan
 * @version 1.0-rc
 */
class MultiplicationOperatorExecutorTest {

    static MultiplicationOperatorExecutor executor;

    @BeforeAll
    static void setup() {
        executor = new MultiplicationOperatorExecutor();
    }

    @Test
    void execute() throws InvalidInputException {
        assertEquals("4", executor.execute("2", "2"));
    }

    @Test
    void operation() {
        assertEquals("*", executor.operation());
    }

    @Test
    void requiredInputCount() {
        assertEquals(2, executor.requiredInputCount());
    }

    @Test
    void invalidInputOnExecute() {
        Assertions.assertThrows(InvalidInputException.class, () -> executor.execute("x", "1"));
    }
}