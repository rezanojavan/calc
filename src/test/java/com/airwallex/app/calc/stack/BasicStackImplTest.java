package com.airwallex.app.calc.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test stack
 *
 * @author Reza Nojavan
 */
class BasicStackImplTest {

    @Test
    void pop() {
        Stack stack = new BasicStackImpl();
        stack.push("x");
        assertEquals("x", stack.pop());
    }

    @Test
    void popExpectNull() {
        Stack stack = new BasicStackImpl();
        assertNull(stack.pop());
    }

    @Test
    void push() {
        Stack stack = new BasicStackImpl();
        stack.push("x");
        assertEquals("x", stack.pop());
    }

    @Test
    void stringRepresentation() {
        Stack stack = new BasicStackImpl();
        stack.push("2");
        stack.push("5");
        String string = stack.toString();
        assertEquals("2 5", string);
    }
}