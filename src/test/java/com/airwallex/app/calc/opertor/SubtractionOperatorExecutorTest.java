package com.airwallex.app.calc.opertor;

import com.airwallex.app.calc.common.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Subtraction operator unit test
 *
 * @author Reza Nojavan
 * @version 1.0-rc
 */
class SubtractionOperatorExecutorTest {

    static SubtractionOperatorExecutor executor;

    @BeforeAll
    static void setup() {
        executor = new SubtractionOperatorExecutor();
    }

    @Test
    void execute() throws InvalidInputException {
        assertEquals("2", executor.execute("4", "2"));
    }

    @Test
    void operation() {
        assertEquals("-", executor.operation());
    }

    @Test
    void requiredInputCount() {
        assertEquals(2, executor.requiredInputCount());
    }

    @Test
    void invalidInputOnExecute() {
        Assertions.assertThrows(InvalidInputException.class, () -> executor.execute("x"));
    }
}