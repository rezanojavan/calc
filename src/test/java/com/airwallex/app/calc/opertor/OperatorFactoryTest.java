package com.airwallex.app.calc.opertor;

import com.airwallex.app.calc.common.exception.OperationNotSupportedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test OperationFactory
 *
 * @author Reza Nojavan
 */
class OperatorFactoryTest {

    @Test
    void getOperationExecutor() {
        Assertions.assertThrows(OperationNotSupportedException.class, () ->
                OperatorFactory.getOperationExecutor("xxx")
        );
    }
}