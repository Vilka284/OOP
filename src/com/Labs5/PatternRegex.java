package com.Labs5;

import java.util.regex.Pattern;

public class PatternRegex {
    public static boolean isValidate(String name, String isbn){
        Pattern patternName = Pattern.compile("[*\\w]");
        Pattern patternISBN = Pattern.compile("\\d{0,4}[-]\\d{0,4}[-]\\d{0,4}");
        boolean validateName = patternName.matcher(name).find();
        boolean validateISBN = patternISBN.matcher(isbn).find();
        if (validateISBN && validateName)
            return true;
        else
            return false;
    }

}
