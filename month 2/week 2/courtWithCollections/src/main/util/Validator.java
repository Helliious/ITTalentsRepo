package main.util;

public class Validator {
    public static boolean isValidString(String text) {
        return text != null && text.length() > 0;
    }
}
