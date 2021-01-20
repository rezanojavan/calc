package com.airwallex.app.calc.common.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Number Utility
 *
 * @author Reza Nojavan
 * @version 1.0-SNAPSHOT
 */
public class NumberUtil {

    private static DecimalFormatSymbols symbol = DecimalFormatSymbols.getInstance();

    static {
        symbol.setDecimalSeparator('.');
    }

    /**
     * This method format value like #,##.##
     *
     * @param value to format
     * @param format to format
     * @return formatted value
     */
    public static String format(Double value, String format) {
        DecimalFormat df = new DecimalFormat(format, symbol);
        return df.format(value);
    }

    /**
     * This method format value like #.##
     *
     * @param value to format
     * @return formatted value
     */
    public static String format15Decimal(Double value) {
        return format(value, "#.###############");
    }

    /**
     * This method format value like #.##
     *
     * @param value to format
     * @return formatted value
     */
    public static String format10Decimal(String value) {
        return format(Double.valueOf(value), "#.##########");
    }
}
