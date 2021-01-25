package com.airwallex.app.calc;

import com.airwallex.app.calc.common.exception.ArithmeticException;
import com.airwallex.app.calc.common.exception.InvalidInputException;
import com.airwallex.app.calc.common.exception.OperationNotSupportedException;
import com.airwallex.app.calc.common.exception.ReadException;
import com.airwallex.app.calc.engine.CalculatorEngine;
import com.airwallex.app.calc.engine.CalculatorEngineImpl;
import com.airwallex.app.calc.input.InputProcessor;
import com.airwallex.app.calc.input.TerminalInputProcessor;
import com.airwallex.app.calc.service.CalculatorService;
import com.airwallex.app.calc.service.CalculatorServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Run Calculator
 *
 * @author Reza Nojavan
 * @version 1.0-rc
 */
public class Application {

    private final static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        InputProcessor inputProcessor = new TerminalInputProcessor();
        CalculatorEngine engine = new CalculatorEngineImpl();
        CalculatorService calculatorService = new CalculatorServiceImpl(engine);

        String result = null;
        List<String> inputs = null;
        while (true) {
            int i = 0;
            try {
                logger.info("Waiting for input: ");
                inputs = inputProcessor.read();
                for (; i < inputs.size(); i++) {
                    if ("exit".equalsIgnoreCase(inputs.get(i))) {
                        logger.info("Result: {}", result);
                        System.exit(0);
                    }
                    result = calculatorService.acceptInput(inputs.get(i));
                }
                logger.info("Result: {}", result);
            } catch (ReadException | OperationNotSupportedException | InvalidInputException e) {
                logger.error(e.getMessage(), e);
            } catch (ArithmeticException e) {
                logger.error("operator {} (position: {}): insuciant parameters", inputs.get(i), (i * 2) + 1);
                logger.info("Result: {}", result);
            }
        }
    }

}
