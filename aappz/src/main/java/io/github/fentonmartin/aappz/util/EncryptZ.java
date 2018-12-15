package io.github.fentonmartin.aappz.util;

import java.util.HashMap;
import java.util.Map;

import io.github.fentonmartin.aappz.constant.EncryptConstant;

public class EncryptZ {

    private static Map<String, String> map;

    /**
     * Preparation for make encryption key based on Map(String, String).
     *
     * @param key   is a collection of characters
     * @param index is a number of characters
     * @return Map(String, String) from key
     */
    private static Map<String, String> prepare(String key, int index) {
        map = new HashMap<>();
        String[] chars = TextZ.convertStringToArray(EncryptConstant.ALL, 1);
        String[] keys = TextZ.convertStringToArray(key, index);
        for (int i = 0; i < EncryptConstant.ALL.length(); i++) {
            map.put(chars[i], keys[i]);
        }
        return map;
    }

    /**
     * Preparation for make encryption key based on Map(String, String).
     *
     * @param key   is a collection of characters
     * @param index is a number of characters
     * @return Map(String, String) from key
     */
    private static Map<String, String> prepareDecrypt(String key, int index) {
        map = new HashMap<>();
        String[] chars = TextZ.convertStringToArray(EncryptConstant.ALL, 1);
        String[] keys = TextZ.convertStringToArray(key, index);
        for (int i = 0; i < EncryptConstant.ALL.length(); i++) {
            map.put(keys[i], chars[i]);
        }
        return map;
    }

    /**
     * Encryption based on Map(String, String) key
     *
     * @param text is an unencrypted text/string/sentences
     * @param key  is a collection of characters
     * @return Map(String, String) from key
     */
    public static String encryptTo(String text, String key) {
        if (key.length() != 86)
            return "";
        map = prepare(key, 1);
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            temp.append(map.get(String.valueOf(text.substring(i, i + 1))));
        }
        return temp.toString();
    }

    /**
     * Decryption based on Map(String, String) key
     *
     * @param text is an encrypted text/string/sentences
     * @param key  is a collection of characters
     * @return Map(String, String) from key
     */
    public static String decryptTo(String text, String key) {
        if (key.length() != 86)
            return "";
        map = prepareDecrypt(key, 1);
        StringBuilder temp = new StringBuilder();
        for (Character c : text.toCharArray()) {
            temp.append(map.get(String.valueOf(c)));
        }
        return temp.toString();
    }
}
