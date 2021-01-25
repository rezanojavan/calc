package com.airwallex.app.calc.opertor;

import com.airwallex.app.calc.common.exception.OperationNotSupportedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test OperatorFactory
 *
 * @author Reza Nojavan
 * @version 1.0-rc
 */
class OperatorFactoryTest {

    @Test
    void operationNotSupportedWhenGetOperatorExecutor() {
        Assertions.assertThrows(OperationNotSupportedException.class, () ->
                OperatorFactory.getOperatorExecutor("xxx")
        );
    }

    @Test
    void getOperatorExecutor() throws OperationNotSupportedException {
        Assertions.assertEquals(AdditionOperatorExecutor.class, OperatorFactory.getOperatorExecutor("+").getClass());
    }


}