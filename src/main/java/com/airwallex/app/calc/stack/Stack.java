package com.airwallex.app.calc.stack;

import org.apiguardian.api.API;

/**
 * This is stack specification that provide two functionalities Pop & Push
 *
 * @author Reza Nojavan
 */
@API(status = API.Status.EXPERIMENTAL)
public interface Stack {

    /**
     * Pop top item of stack. If stack empty then return null
     *
     * @return top item of stack
     */
    String pop();

    /**
     * this method push new item into stack
     *
     * @param item to push to stack
     */
    void push(String item);

    /**
     * Get current size of stack
     *
     * @return size of stack
     */
    int size();

    /**
     * Convert stack to string representation
     *
     * @return string representation
     */
    String toString();
}
