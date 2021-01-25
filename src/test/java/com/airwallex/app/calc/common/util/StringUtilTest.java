package com.airwallex.app.calc.common.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test StringUtil
 */
class StringUtilTest {

    /**
     * Sample string that used by tests
     */
    private static final String TEST_STRING = "5 2 *";

    @Test
    void splitBySpace() {
        String[] strings = StringUtil.splitBySpace(TEST_STRING);
        assertNotNull(strings);
        assertEquals(3, strings.length);
    }

    @Test
    void split() {
        String[] strings = StringUtil.split(TEST_STRING, " ");
        assertNotNull(strings);
        assertEquals(3, strings.length);
    }

    @Test
    void splitWhenNoSpaceExist() {
        String[] strings = StringUtil.split("5", " ");
        assertNotNull(strings);
        assertEquals(1, strings.length);
    }

    @Test
    void listBySpace() {
        List<String> strings = StringUtil.listBySpace(TEST_STRING);
        assertNotNull(strings);
        assertEquals(3, strings.size());
    }

    @Test
    void isDigit() {
        assertTrue(StringUtil.isDigit("1"));
    }

    @Test
    void isNotDigit() {
        assertFalse(StringUtil.isDigit("x"));
    }

}