package com.airwallex.app.calc.history;


import java.util.Stack;

/**
 * This class implement {@code History} specification that use a stack as backend. This is very basic implementation
 * of history spec so there is no limitation exist on items that will be store in the history
 *
 * @author Reza Nojavan
 * @version 1.0-SNAPSHOT
 */
public class StackBackendHistoryServiceImpl implements HistoryService {

    /**
     * Stack that hold history
     */
    private Stack<String[]> stack = new Stack<>();

    @Override
    public void store(String[] item) {
        stack.push(item);
    }

    @Override
    public String[] retrieve() {
        return stack.pop();
    }
}
