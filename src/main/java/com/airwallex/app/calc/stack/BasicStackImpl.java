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

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for ( int i = 0; i < stack.size(); i++ )
            buffer.append(stack.elementAt(i)).append(" ");
        return buffer.toString().trim();
    }
}
