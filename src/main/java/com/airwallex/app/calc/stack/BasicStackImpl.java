package com.airwallex.app.calc.stack;

import java.util.EmptyStackException;

/**
 * This class implement stack by {@code java.util.Stack}
 *
 * @author Reza Nojavan
 * @version 1.0-SNAPShOT
 */
public class BasicStackImpl implements Stack {
    /**
     * Backend stack
     */
    private java.util.Stack<String> stack = new java.util.Stack<>();

    @Override
    public String pop() {
        try {
            return stack.pop();
        } catch ( EmptyStackException ex) {
            return null;
        }
    }

    @Override
    public void push(String item) {
        stack.push(item);
    }
}
