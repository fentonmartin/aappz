package io.github.fentonmartin.aappz.util;

import java.util.HashMap;
import java.util.Map;

import io.github.fentonmartin.aappz.constant.EncryptConstant;

public class EncryptZ {

    private static Map<String, String> map;

    /**
     * Preparation for make default of Map(String, String)
     *
     * @param input       is a collection of input characters
     * @param inputIndex  is an index of input characters
     * @param output      is a collection of output characters
     * @param outputIndex is an index of output characters
     * @return Map(String, String) from key
     */
    private static Map<String, String> prepare(String input, String output, int inputIndex, int outputIndex) {
        map = new HashMap<>();
        String[] inputs = TextZ.convertStringToArray(input, inputIndex);
        String[] outputs = TextZ.convertStringToArray(output, outputIndex);
        for (int i = 0; i < EncryptConstant.ALL.length(); i++) {
            map.put(inputs[i], outputs[i]);
        }
        return map;
    }

    /**
     * Preparation for make encryption based on Map(String, String)
     *
     * @param key   is a collection of characters
     * @param index is an index of characters
     * @return Map(String, String) from key
     */
    private static Map<String, String> prepareEncrypt(String key, int index) {
        return prepare(EncryptConstant.ALL, key, 1, index);
    }

    /**
     * Preparation for make decryption based on Map(String, String)
     *
     * @param key   is a collection of characters
     * @param index is an index of characters
     * @return Map(String, String) from key
     */
    private static Map<String, String> prepareDecrypt(String key, int index) {
        return prepare(key, EncryptConstant.ALL, index, 1);
    }

    /**
     * Encryption based on Map(String, String) key
     *
     * @param text is an unencrypted text/string/sentences
     * @param key  is a collection of characters
     * @return ENCRYPTED Map(String, String) from key
     */
    public static String encryptTo(String text, String key) {
        if (key.length() != 86)
            return "";
        map = prepareEncrypt(key, 1);
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
     * @return DECRYPTED Map(String, String) from key
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
