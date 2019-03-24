package com.Labs;

import java.util.List;
import java.util.ArrayList;

public class Split {

    public static List<String> splitEx(String text, String split)
    {
        List<String> words = new ArrayList<>();
        int startIndex = 0;
        for (int i = 0; i < text.length(); i++)
        {
            if (text.contains(split))
            {
                int lastIndex = text.indexOf(split, i);
                if (lastIndex == -1)
                    lastIndex = text.length();
                String buffer = text.substring(startIndex, lastIndex);
                words.add(buffer);
                startIndex = ++i;
            }
        }
        if (!words.isEmpty()) {
            return words;
        } else {
            words.add(text);
            return words;
        }
    }
}
