package io.github.fentonmartin.aappz.util;

import java.util.HashMap;
import java.util.Map;

import io.github.fentonmartin.aappz.constant.EncryptConstant;

public class EncryptZ {

    private static Map<String, String> map;
    private static final String ERROR_NOT_SUPPORTED = "EncryptZ Error: Not supported character ";
    private static final String ERROR_NOT_VALID_INDEX = "EncryptZ Error: Index is valid (not a multiples of 92 characters)";

    private static Map<String, String> prepare(String input, String output, int inputIndex, int outputIndex) {
        map = new HashMap<>();
        String[] inputs = TextZ.getArrayFrom(input, inputIndex);
        String[] outputs = TextZ.getArrayFrom(output, outputIndex);
        for (int i = 0; i < EncryptConstant.ALL_92.length(); i++) {
            map.put(inputs[i], outputs[i]);
        }
        return map;
    }

    private static Map<String, String> prepareEncrypt(String key, int index) {
        return prepare(EncryptConstant.ALL_92, key, 1, index);
    }

    private static Map<String, String> prepareDecrypt(String key, int index) {
        return prepare(key, EncryptConstant.ALL_92, index, 1);
    }

    private static String encryptTo(String text, String key, int index) {
        if (key.length() != 92 * index)
            return ERROR_NOT_VALID_INDEX;
        map = prepareEncrypt(key, index);
        String s;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            s = text.substring(i, i + 1);
            if (map.get(s) == null)
                return ERROR_NOT_SUPPORTED + s;
            temp.append(map.get(s));
        }
        return temp.toString();
    }

    private static String decryptTo(String text, String key, int index) {
        map = prepareDecrypt(key, index);
        String s;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < text.length() / index; i++) {
            s = text.substring(i * index, (i * index) + index);
            temp.append(map.get(s));
            if (map.get(s) == null)
                return ERROR_NOT_SUPPORTED + s;
        }
        return temp.toString();
    }

    /**
     * Encryption based on Map(String, String) key
     *
     * @param text is an unencrypted text/string/sentences
     * @param key  is a collection of multiples of 92 characters
     * @return ENCRYPTED Map(String, String) from key
     */
    public static String encryptTo(String text, String key) {
        if (key.length() % 92 > 0)
            return ERROR_NOT_VALID_INDEX;
        return encryptTo(text, key, key.length() / 92);
    }

    /**
     * Decryption based on Map(String, String) key
     *
     * @param text is an encrypted text/string/sentences
     * @param key  is a collection of multiples of 92 characters
     * @return DECRYPTED Map(String, String) from key
     */
    public static String decryptTo(String text, String key) {
        if (key.length() % 92 > 0 || text.length() % (key.length() / 92) > 0)
            return ERROR_NOT_VALID_INDEX;
        return decryptTo(text, key, key.length() / 92);
    }
}
