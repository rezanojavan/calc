package com.airwallex.app.calc.input;

import com.airwallex.app.calc.common.exception.ReadException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test of the {@code TerminalInputProcessor}
 */
@ExtendWith(MockitoExtension.class)
class TerminalInputProcessorTest {

    @Mock
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        Mockito.when(scanner.nextLine()).thenReturn("5 2 *");
    }

    @Test()
    void read() throws ReadException {
        TerminalInputProcessor terminalInputProcessor = new TerminalInputProcessor(scanner);
        List<String> input = terminalInputProcessor.read();
        assertNotNull(input);
        assertEquals(3, input.size());
        assertEquals("5", input.get(0));
        assertEquals("2", input.get(1));
        assertEquals("*", input.get(2));
    }
}