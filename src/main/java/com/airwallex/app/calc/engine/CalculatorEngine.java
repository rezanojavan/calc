package com.airwallex.app.calc.engine;

import com.airwallex.app.calc.common.exception.ArithmeticException;
import com.airwallex.app.calc.common.exception.InvalidInputException;
import com.airwallex.app.calc.common.exception.OperationNotSupportedException;
import org.apiguardian.api.API;


/**
 * Calculate engine specification
 *
 * @author Reza Nojavan
 */
@API(status = API.Status.EXPERIMENTAL)
public interface CalculatorEngine {

    /**
     * Get new input and execute calculation
     *
     * @param input to accept
     * @throws ArithmeticException if any exception
     */
    void accept(String input) throws ArithmeticException, InvalidInputException, OperationNotSupportedException;

    /**
     * Get current result;
     * @return string
     */
    String getResult();
}
