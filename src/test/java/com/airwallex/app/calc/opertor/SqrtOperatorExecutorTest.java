package com.airwallex.app.calc.opertor;

import com.airwallex.app.calc.common.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Sqrt operator unit test
 *
 * @author Reza Nojavan
 * @version 1.0-SNAPSHOT
 */
class SqrtOperatorExecutorTest {

    static SqrtOperatorExecutor executor;

    @BeforeAll
    static void setup() {
        executor = new SqrtOperatorExecutor();
    }

    @Test
    void execute() throws InvalidInputException {
        assertEquals("2", executor.execute("4"));
    }

    @Test
    void operation() {
        assertEquals("sqrt", executor.operation());
    }

    @Test
    void requiredInputCount() {
        assertEquals(1, executor.requiredInputCount());
    }

    @Test
    void invalidInputOnExecute() {
        Assertions.assertThrows(InvalidInputException.class, () -> executor.execute("x"));
    }
}