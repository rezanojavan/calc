package com.airwallex.app.calc.input;

import com.airwallex.app.calc.common.exception.ReadException;
import com.airwallex.app.calc.common.util.StringUtil;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class is responsible to get input from terminal. This terminal processor read a line and split it by space then
 * return it as a list of string
 *
 * @author Reza Nojava
 * @version 1.1-SNAPSHOT
 */
public class TerminalInputProcessor implements InputProcessor {

    /**
     * The scanner to read {@code System.in}
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Default constructor
     */
    public TerminalInputProcessor() {
    }

    /**
     * The constructor that initiate scanner
     *
     * @param scanner to initiate
     */
    public TerminalInputProcessor(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * This method read a line from terminal and split it by space
     *
     * @return list of string
     * @throws ReadException if any exception happened
     */
    public List<String> read() throws ReadException {
        try {
            String line = scanner.nextLine();
            return StringUtil.listBySpace(line);
        } catch (NoSuchElementException ex) {
            throw new ReadException("No input available to read", ex);
        } catch (IllegalStateException ex) {
            throw new ReadException("No terminal available to read", ex);
        }
    }
}
