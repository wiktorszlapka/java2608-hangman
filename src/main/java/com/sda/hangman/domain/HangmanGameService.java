package com.sda.hangman.domain;

import java.util.ArrayList;
import java.util.List;

public class HangmanGameService {

    public List<Integer> performCharacter(char c, String phrase) {
        char[] chareFromPhrase = phrase.toCharArray();
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < chareFromPhrase.length; i++){
            if (equalsIgnoreCase(c, chareFromPhrase[i])) {
                result.add(i);

            }
        }

        return result;
    }

    private boolean equalsIgnoreCase(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }
}
