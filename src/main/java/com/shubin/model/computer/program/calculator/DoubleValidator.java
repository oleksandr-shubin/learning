package com.shubin.model.computer.program.calculator;

import java.util.regex.Pattern;

public class DoubleValidator {
    public static final String DIGITS = "(\\p{Digit}+)";
    public static final String HEX_DIGITS = "(\\p{XDigit}+)";

    // an exponent is 'e' or 'E' followed by an optionally
    // signed decimal integer.
    public static final String EXP = "[eE][+-]?" + DIGITS;
    public static final String FP_REGEX =
            ("[\\x00-\\x20]*" +  // Optional leading "whitespace"
                    "[+-]?(" + // Optional sign character
                    "NaN|" +           // "NaN" string
                    "Infinity|" +      // "Infinity" string

                    // A decimal floating-point string representing a finite positive
                    // number without a leading sign has at most five basic pieces:
                    // DIGITS . DIGITS ExponentPart FloatTypeSuffix
                    //
                    // Since this method allows integer-only strings as input
                    // in addition to strings of floating-point literals, the
                    // two sub-patterns below are simplifications of the grammar
                    // productions from section 3.10.2 of
                    // The Java Language Specification.

                    // DIGITS ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
                    "(((" + DIGITS + "(\\.)?(" + DIGITS + "?)(" + EXP + ")?)|" +

                    // . DIGITS ExponentPart_opt FloatTypeSuffix_opt
                    "(\\.(" + DIGITS + ")(" + EXP + ")?)|" +

                    // Hexadecimal strings
                    "((" +
                    // 0[xX] HEX_DIGITS ._opt BinaryExponent FloatTypeSuffix_opt
                    "(0[xX]" + HEX_DIGITS + "(\\.)?)|" +

                    // 0[xX] HexDigits_opt . HEX_DIGITS BinaryExponent FloatTypeSuffix_opt
                    "(0[xX]" + HEX_DIGITS + "?(\\.)" + HEX_DIGITS + ")" +

                    ")[pP][+-]?" + DIGITS + "))" +
                    "[fFdD]?))" +
                    "[\\x00-\\x20]*");// Optional trailing "whitespace"

    /**
     * @param s string to be checked
     * @return whether string is a double representation or not
     */
    public static boolean isValidDouble(String s) {
        return Pattern.matches(FP_REGEX, s);
    }


}
