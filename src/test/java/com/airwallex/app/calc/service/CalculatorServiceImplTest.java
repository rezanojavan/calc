package com.airwallex.app.calc.service;

import com.airwallex.app.calc.common.exception.ArithmeticException;
import com.airwallex.app.calc.common.exception.InvalidInputException;
import com.airwallex.app.calc.common.exception.OperationNotSupportedException;
import com.airwallex.app.calc.engine.CalculatorEngine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Calculator Service unit test
 *
 * @author Reza Nojavan
 * @version 1.0-rc
 */
class CalculatorServiceImplTest {

    static CalculatorService calculatorService;

    static CalculatorEngine engine;

    @BeforeAll
    static void setup() throws InvalidInputException, OperationNotSupportedException, ArithmeticException {
        engine = Mockito.mock(CalculatorEngine.class);
        Mockito.doNothing().when(engine).accept(Mockito.any(String.class));
        calculatorService = new CalculatorServiceImpl(engine);

    }

    @Test
    void acceptInput() throws InvalidInputException, OperationNotSupportedException, ArithmeticException {
        Mockito.when(engine.getResult()).thenReturn("1");
        assertEquals("1", calculatorService.acceptInput("1"));
    }

    @Test
    void testAcceptInput() throws InvalidInputException, OperationNotSupportedException, ArithmeticException {
        Mockito.when(engine.getResult()).thenReturn("1 2");
        assertEquals("1 2", calculatorService.acceptInput(Arrays.asList("1", "2")));
    }

    @Test
    void getResult() {
        Mockito.when(engine.getResult()).thenReturn("1 2");
        assertEquals("1 2", calculatorService.getResult());
    }
}