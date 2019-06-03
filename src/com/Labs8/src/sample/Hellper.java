package sample;

import java.util.regex.Pattern;

public class Hellper {
    public static boolean isXMLformat(String psth){
        return true;
    }
    public static boolean isValidISBN(String s){
        Pattern pattern = Pattern.compile("\\d{0,16}");
        return pattern.matcher(s).find();
    }
}
