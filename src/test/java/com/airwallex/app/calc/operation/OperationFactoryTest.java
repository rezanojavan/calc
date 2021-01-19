package com.airwallex.app.calc.operation;

import com.airwallex.app.calc.common.exception.OperationNotSupportedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test OperationFactory
 *
 * @author Reza Nojavan
 */
class OperationFactoryTest {

    @Test
    void getOperationExecutor() {
        Assertions.assertThrows(OperationNotSupportedException.class, () ->
                OperationFactory.getOperationExecutor("xxx")
        );
    }
}