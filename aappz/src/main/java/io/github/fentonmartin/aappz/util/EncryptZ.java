package io.github.fentonmartin.aappz.util;

import java.util.HashMap;
import java.util.Map;

import io.github.fentonmartin.aappz.constant.EncryptConstant;

public class EncryptZ {

    private static Map<String, String> map;

    private static Map<String, String> prepare(String input, String output, int inputIndex, int outputIndex) {
        map = new HashMap<>();
        String[] inputs = TextZ.convertStringToArray(input, inputIndex);
        String[] outputs = TextZ.convertStringToArray(output, outputIndex);
        for (int i = 0; i < EncryptConstant.ALL.length(); i++) {
            map.put(inputs[i], outputs[i]);
        }
        return map;
    }

    private static Map<String, String> prepareEncrypt(String key, int index) {
        return prepare(EncryptConstant.ALL, key, 1, index);
    }

    private static Map<String, String> prepareDecrypt(String key, int index) {
        return prepare(key, EncryptConstant.ALL, index, 1);
    }

    private static String encryptTo(String text, String key, int index) {
        if (key.length() != 86 * index)
            return "";
        map = prepareEncrypt(key, index);
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            temp.append(map.get(String.valueOf(text.substring(i, i + 1))));
        }
        return temp.toString();
    }

    private static String decryptTo(String text, String key, int index) {
        map = prepareDecrypt(key, index);
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < text.length() / index; i++) {
            temp.append(map.get(String.valueOf(text.substring(i * index, (i * index) + index))));
            if (map.get(String.valueOf(text.substring(i * index, (i * index) + index))) == null)
                return "";
        }
        return temp.toString();
    }

    /**
     * Encryption based on Map(String, String) key
     *
     * @param text is an unencrypted text/string/sentences
     * @param key  is a collection of multiples of 86 characters
     * @return ENCRYPTED Map(String, String) from key
     */
    public static String encryptTo(String text, String key) {
        if (key.length() % 86 > 0)
            return "";
        return encryptTo(text, key, key.length() / 86);
    }

    /**
     * Decryption based on Map(String, String) key
     *
     * @param text is an encrypted text/string/sentences
     * @param key  is a collection of multiples of 86 characters
     * @return DECRYPTED Map(String, String) from key
     */
    public static String decryptTo(String text, String key) {
        if (key.length() % 86 > 0 || text.length() % (key.length() / 86) > 0)
            return "";
        return decryptTo(text, key, key.length() / 86);
    }
}
