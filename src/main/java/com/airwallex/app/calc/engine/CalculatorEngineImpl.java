package com.airwallex.app.calc.engine;

import com.airwallex.app.calc.common.exception.ArithmeticException;
import com.airwallex.app.calc.common.exception.InvalidInputException;
import com.airwallex.app.calc.common.exception.OperationNotSupportedException;
import com.airwallex.app.calc.common.util.StringUtil;
import com.airwallex.app.calc.history.HistoryService;
import com.airwallex.app.calc.history.StackBackendHistoryServiceImpl;
import com.airwallex.app.calc.opertor.OperatorExecutor;
import com.airwallex.app.calc.opertor.OperatorFactory;
import com.airwallex.app.calc.stack.BasicStackImpl;
import com.airwallex.app.calc.stack.Stack;


/**
 * Calculate engine implementation.
 *
 * @author Reza Nojavan
 * @version 1.0-SNAPSHOT
 */
public class CalculatorEngineImpl implements CalculatorEngine {

    /**
     * stack to hold inputs
     */
    private Stack stack = new BasicStackImpl();

    /**
     * History service
     */
    private HistoryService historyService = new StackBackendHistoryServiceImpl();

    @Override
    public void accept(String input) throws ArithmeticException, InvalidInputException, OperationNotSupportedException {
        if (StringUtil.isDigit(input)) {
            historyService.store(new String[]{"P"});
            stack.push(input);
            return;
        }
        execute(input);
    }

    @Override
    public String getResult() {
        return stack.toString();
    }

    /**
     * Execute input
     *
     * @param input to execute
     */
    private void execute(String input) throws ArithmeticException, OperationNotSupportedException,
            InvalidInputException {
        if ( isEngineOperation(input) ) {
            executeEngineOperation(input);
        } else {
            executeOperator(input);
        }
    }

    /**
     * Get required inputs
     *
     * @param count to get
     * @return inputs
     */
    private String[] getInputs(int count) {
        String[] inputs = new String[count];
        for (int i = count - 1; i >= 0; i--)
            inputs[i] = stack.pop();
        return inputs;
    }

    /**
     * This method execute operators
     *
     * @param operator to execute
     */
    private void executeOperator(String operator) throws ArithmeticException, OperationNotSupportedException, InvalidInputException {
        OperatorExecutor executor = OperatorFactory.getOperationExecutor(operator);
        int requiredInput = executor.requiredInputCount();
        if (!(stack.size() >= requiredInput))
            throw new ArithmeticException("Not enough input");
        String[] numbers = getInputs(requiredInput);
        historyService.store(numbers);
        String result = executor.execute(numbers);
        stack.push(result);
    }

    /**
     * This method execute engine operations
     *
     * @param operation to execute
     * @throws OperationNotSupportedException if invalid operation found
     */
    private void executeEngineOperation(String operation) throws OperationNotSupportedException {
        if ( operation.equalsIgnoreCase(EngineOperationEnum.CLEAR.name()) ){
            clear();
        } else if ( operation.equalsIgnoreCase(EngineOperationEnum.UNDO.name()) ) {
            undo();
        } else {
            throw new OperationNotSupportedException(String.format("Operation %s not supported by engine", operation));
        }
    }

    /**
     * Check the input is an engine operation or not. clear and undo are engine operation
     *
     * @param input to check
     * @return true if are engine operation
     */
    private boolean isEngineOperation(String input) {
        return input.equalsIgnoreCase(EngineOperationEnum.CLEAR.name()) ||
                input.equalsIgnoreCase(EngineOperationEnum.UNDO.name());
    }

    /**
     * This method clear engine and make a fresh state
     */
    private void clear() {
        stack.clear();
    }

    /**
     * This method undo last operation
     */
    private void undo() {
        String[] historyRecord = historyService.retrieve();
        // if there is no history record then nothing happen.
        if ( historyRecord == null )
            return;
        stack.pop();
        for ( int i = historyRecord.length - 1; i >= 0; i--) {
            if ( !historyRecord[i].equalsIgnoreCase("P") )
                stack.push(historyRecord[i]);
        }
    }

    enum EngineOperationEnum {
        CLEAR, UNDO
    }


}
