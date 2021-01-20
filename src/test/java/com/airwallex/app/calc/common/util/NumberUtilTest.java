package com.airwallex.app.calc.common.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test utility
 */
class NumberUtilTest {

    @Test
    void format() {
        String formatted = NumberUtil.format(2.222D, "#.##");
        assertEquals("2.22", formatted);
    }

    @Test
    void format15Decimal() {
        String formatted = NumberUtil.format(2.123456789123456789D, "#.###############");
        assertEquals("2.123456789123457", formatted);
    }

    @Test
    void format10Decimal() {
        String formatted = NumberUtil.format(2.123456789123456789D, "#.##########");
        assertEquals("2.1234567891", formatted);
    }
}