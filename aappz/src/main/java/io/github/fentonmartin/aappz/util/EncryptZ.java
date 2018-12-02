package io.github.fentonmartin.aappz.util;

import java.util.HashMap;
import java.util.Map;

import io.github.fentonmartin.aappz.constant.EncryptConstant;

public class EncryptZ {

    private static Map<Character, Character> charMap;
    private static Map<String, String> stringMap;

    private static Map<Character, Character> prepare() {
        charMap = new HashMap<>();
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

    private static Map<String, String> prepare(String[] before, String[] after) {
        stringMap = new HashMap<>();
        for (int i = 0; i < before.length; i++) {
            stringMap.put(before[i], after[i]);
        }
        return stringMap;
    }

    private static Map<String, String> prepare(String[] after, int totalAfter) {
        stringMap = new HashMap<>();
        String[] chars = TextZ.convertStringToArray(EncryptConstant.ALL, totalAfter);
        for (int i = 0; i < EncryptConstant.ARRAY_ALL.length; i++) {
            stringMap.put(chars[i], after[i]);
        }
        return stringMap;
    }

    public static String encryptToMirror(String inputString) {
        charMap = prepare();
        StringBuilder temp = new StringBuilder();
        for (Character c : inputString.toCharArray()) {
            temp.append(charMap.get(c));
        }
        return temp.toString();
    }

    public static String encryptTo(String inputString, String[] after) {
        stringMap = prepare(after, 1);
        StringBuilder temp = new StringBuilder();
        for (Character c : inputString.toCharArray()) {
            temp.append(stringMap.get(String.valueOf(c)));
        }
        return temp.toString();
    }

    public static String decryptTo(String inputString, String[] before) {
        stringMap = prepare(before, 1);
        StringBuilder temp = new StringBuilder();
        for (Character c : inputString.toCharArray()) {
            temp.append(stringMap.get(String.valueOf(c)));
        }
        return temp.toString();
    }

    public static String encryptTo(String inputString, String[] after, int totalAfter) {
        stringMap = prepare(after, totalAfter);
        StringBuilder temp = new StringBuilder();
        for (Character c : inputString.toCharArray()) {
            temp.append(stringMap.get(String.valueOf(c)));
        }
        return temp.toString();
    }
}
