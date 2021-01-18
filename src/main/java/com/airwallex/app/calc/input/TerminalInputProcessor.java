package com.airwallex.app.calc.input;

import com.airwallex.app.calc.common.exception.ReadException;
import com.airwallex.app.calc.common.util.StringUtil;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class is responsible to get input from terminal. This terminal accept input as below format<br>
 * format: <br>
 *     [digit][space]([digit][space]){0,n}[operator]([operator][space]{0,n})
 * example : <br>
 *     <ol>
 *         <li>5 2 *</li>
 *         <li>6 7 8 + *</li>
 *     </ol>
 *
 * @author Reza Nojava
 */
public class TerminalInputProcessor implements InputProcessor {

    /**
     * The scanner to read {@code System.in}
     */
    private Scanner scanner = new Scanner(System.in);

    public List<String> read() throws ReadException {
        try {
            String line = scanner.nextLine();
            return StringUtil.listBySpace(line);
        } catch ( NoSuchElementException ex) {
            throw new ReadException("No input available to read", ex);
        } catch ( IllegalStateException ex) {
            throw new ReadException("No terminal available to read", ex);
        }
    }
}
