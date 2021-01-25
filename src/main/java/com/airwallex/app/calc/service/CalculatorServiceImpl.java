package com.airwallex.app.calc.service;

import com.airwallex.app.calc.common.exception.ArithmeticException;
import com.airwallex.app.calc.common.exception.InvalidInputException;
import com.airwallex.app.calc.common.exception.OperationNotSupportedException;
import com.airwallex.app.calc.engine.CalculatorEngine;

import java.util.List;

/**
 * Calculator service implementation
 *
 * @author Reza Nojavan
 * @version 1.0-SNAPSHOT
 */
public class CalculatorServiceImpl implements CalculatorService {

    /**
     * Calculator engine
     */
    private CalculatorEngine engine;

    /**
     * Constructor that set the engine
     *
     * @param engine to set
     */
    public CalculatorServiceImpl(CalculatorEngine engine) {
        this.engine = engine;
    }

    @Override
    public String acceptInput(String input) throws InvalidInputException, OperationNotSupportedException, ArithmeticException {
        engine.accept(input);
        return engine.getResult();
    }

    @Override
    public String acceptInput(List<String> inputs) throws InvalidInputException, ArithmeticException, OperationNotSupportedException {
        String result = "";
        for (int i = 0; i < inputs.size(); i++)
            result = acceptInput(inputs.get(i));
        return result;
    }

    @Override
    public String getResult() {
        return engine.getResult();
    }
}
