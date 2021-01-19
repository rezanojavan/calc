package com.airwallex.app.calc.common.util;

import java.util.Arrays;
import java.util.List;

/**
 * String utility
 *
 * @author Reza Nojavan
 * @version 1.0-SNAPSHOT
 */
public class StringUtil {

    /**
     * This method split given string by space
     *
     * @param str to split
     * @return split string
     */
    public static String[] splitBySpace(String str) {
        return split(str, " ");
    }

    /**
     * This method split string by given regex
     *
     * @param str   to split
     * @param regex to split
     * @return split string
     */
    public static String[] split(String str, String regex) {
        return str.split(regex);
    }

    /**
     * This method split string by space and convert to a {@code List}
     *
     * @param str to split
     * @return a list of split string
     */
    public static List<String> listBySpace(String str) {
        return Arrays.asList(splitBySpace(str));
    }

    /**
     * This method checks input is a digit or not
     *
     * @param input to check
     * @return true if digit otherwise false
     */
    public static boolean isDigit(String input) {
        try {
            Double.valueOf(input);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
