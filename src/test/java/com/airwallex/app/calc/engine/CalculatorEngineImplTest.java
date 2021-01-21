package com.airwallex.app.calc.engine;

import com.airwallex.app.calc.common.exception.ArithmeticException;
import com.airwallex.app.calc.common.exception.InvalidInputException;
import com.airwallex.app.calc.common.exception.OperationNotSupportedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test Calculation engine
 *
 * @author Reza
 */
class CalculatorEngineImplTest {

    CalculatorEngine calculateEngine = new CalculatorEngineImpl();

    @Test
    void accept() throws ArithmeticException, InvalidInputException, OperationNotSupportedException{
        calculateEngine.accept("5");
        calculateEngine.accept("2");
        calculateEngine.accept("+");
        assertEquals("7", calculateEngine.getResult());
        calculateEngine.accept("2");
        calculateEngine.accept("+");
        assertEquals("9", calculateEngine.getResult());
    }

    @Test
    void getResult() throws ArithmeticException, InvalidInputException, OperationNotSupportedException {
        calculateEngine.accept("5");
        assertEquals("5", calculateEngine.getResult());
    }

    @Test
    void acceptOperationNotSupported() {
        Assertions.assertThrows(OperationNotSupportedException.class, () -> calculateEngine.accept("x"));
    }

    @Test
    void acceptArithmeticException() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
                calculateEngine.accept("2");
                calculateEngine.accept("5");
                calculateEngine.accept("+");
                calculateEngine.accept("+");
        });
    }

    @Test
    void clear() throws InvalidInputException, OperationNotSupportedException, ArithmeticException {
        calculateEngine.accept("2");
        calculateEngine.accept("5");
        calculateEngine.accept("clear");
        Assertions.assertThrows(ArithmeticException.class, () -> calculateEngine.accept("+"));
    }

}