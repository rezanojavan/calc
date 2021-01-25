package com.airwallex.app.calc.history;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * History implementation unit test
 *
 * @author Reza Nojavan
 * @version 1.0-rc
 */
class StackBackendHistoryServiceImplTest {

    static StackBackendHistoryServiceImpl historyService;
    static String[] historyRecord = new String[]{"2", "5"};

    @BeforeAll
    static void setup() {
        historyService =  new StackBackendHistoryServiceImpl();
    }

    @Test
    void store() {
        historyService.store(historyRecord);
    }

    @Test
    void retrieve() {
        historyService.store(historyRecord);
        String[] record = historyService.retrieve();
        assertEquals(historyRecord, record);
    }
}