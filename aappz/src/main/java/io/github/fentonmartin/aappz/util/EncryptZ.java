package io.github.fentonmartin.aappz.util;

import java.util.HashMap;
import java.util.Map;

import io.github.fentonmartin.aappz.constant.EncryptConstant;

public class EncryptZ {

    private static Map<Character, Character> charMap;

    private static Map<Character, Character> prepare() {
        Map<Character, Character> charMap = new HashMap<>();
        for (int i = 0; i < EncryptConstant.ARRAY_NUMERIC_ASC.length - 1; i++) {
            charMap.put(EncryptConstant.ARRAY_NUMERIC_ASC[i], EncryptConstant.ARRAY_NUMERIC_DSC[i]);
        }
        for (int i = 0; i < EncryptConstant.ARRAY_ALPHABET_LOWER_ASC.length - 1; i++) {
            charMap.put(EncryptConstant.ARRAY_ALPHABET_LOWER_ASC[i], EncryptConstant.ARRAY_ALPHABET_LOWER_DSC[i]);
        }
        for (int i = 0; i < EncryptConstant.ARRAY_ALPHABET_UPPER_ASC.length - 1; i++) {
            charMap.put(EncryptConstant.ARRAY_ALPHABET_UPPER_ASC[i], EncryptConstant.ARRAY_ALPHABET_UPPER_DSC[i]);
        }
        return charMap;
    }

    static {
        charMap = prepare();
    }

    public static String convertToMirror(String inputString) {
        StringBuilder temp = new StringBuilder();
        for (Character c : inputString.toCharArray()) {
            temp.append(charMap.get(c));
        }
        return temp.toString();
    }
}
