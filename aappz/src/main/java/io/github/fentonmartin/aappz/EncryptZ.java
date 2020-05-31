package io.github.fentonmartin.aappz;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"unused", "WeakerAccess"})
public class EncryptZ {

    private static Map<String, String> map;
    private static final String ERROR_NOT_SUPPORTED = "EncryptZ Error: Not supported character ";
    private static final String ERROR_NOT_VALID_INDEX = "EncryptZ Error: Index is valid (not a multiples of 92 characters)";

    private static Map<String, String> prepare(String input, String output, int inputIndex, int outputIndex) {
        map = new HashMap<>();
        String[] inputs = TextZ.getArrayFrom(input, inputIndex);
        String[] outputs = TextZ.getArrayFrom(output, outputIndex);
        for (int i = 0; i < ALL_92.length(); i++) {
            map.put(inputs[i], outputs[i]);
        }
        return map;
    }

    private static Map<String, String> prepareEncrypt(String key, int index) {
        return prepare(ALL_92, key, 1, index);
    }

    private static Map<String, String> prepareDecrypt(String key, int index) {
        return prepare(key, ALL_92, index, 1);
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

    /**
     * Encryption based on default Map(String, String) key
     *
     * @param text is an unencrypted text/string/sentences
     * @return ENCRYPTED Map(String, String) from default key
     */
    public static String encryptDefault(String text) {
        String key = ENCRYPT_276;
        return encryptTo(text, key, key.length() / 92);
    }

    /**
     * Decryption based on default Map(String, String) key
     *
     * @param text is an encrypted text/string/sentences
     * @return DECRYPTED Map(String, String) from default key
     */
    public static String decryptDefault(String text) {
        String key = ENCRYPT_276;
        return decryptTo(text, key, key.length() / 92);
    }

    /* Encrypt Constants -------------------------------------------------------------------------*/

    /* All alphanumerics and symbols */
    public static final String ALL_92 = " _.,~-:;+=|/!@()<>?{}[]#$%&*^`0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static final String SYMBOLS = " _.,~-:;+=|/!@()<>?{}[]#$%&*^`";

    /* All numeric */
    private static final String NUMERIC_ASC = "0123456789";
    private static final String NUMERIC_DSC = "9876543210";

    /* All alphabet */
    private static final String ALPHABET_LOWER_ASC = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALPHABET_LOWER_DSC = "zyxwvutsrqponmlkjihgfedcba";
    private static final String ALPHABET_UPPER_ASC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHABET_UPPER_DSC = "ZYXWVUTSRQPONMLKJIHGFEDCBA";

    /* Default key */
    public static final String ENCRYPT_62 = "qZnrT8X5Lgh63lA910tGdJ2OeKNPBUxbSHyIQRuYVFwWsacCDp47ijMfmEkzvo";
    public static final String ENCRYPT_92 = "*[?} ~!&^>/%:{-]`<($+)@.;=,#|_qZnrT8X5Lgh63lA910tGdJ2OeKNPBUxbSHyIQRuYVFwWsacCDp47ijMfmEkzvo";
    public static final String ENCRYPT_184 = "CW7qgzOf2XfynJFMXuVavj4kcorXJkFfbBwmDtI5FJDV9DIyO9b2oxaYbybI4YpLzAvsUpnvbhYmIGn2Sv5fR1aKj5JivKSWEaVdInGTWOGB236Gd24QvtYP6DizZvQae3OAIm1MJ9DIbo0mEtgGkTotcvsaujIDRuWeGtknEYl4f6FkX8qReb9a";
    public static final String ENCRYPT_276 = "WdzSM9ARuiNZb8FjDNODuEhEvHhdSNBLm1lXBIEOSKZLOli14OvxWATEgNSVv1gsOHG5nHoMUGxgkXwMt9qfcQGacgGeo2H68NQN5hPsaGv0gnuSdmux1nphRpX9uSyPa06HMEyiB0fDJguzeVPgRbpqLLkAQZCCPbzQB8GQN6WDRu0Fxar6ZeHnvmQ2GXUVZUrwj2RvwGlPDlxB41cadYq963TnMrePdlSnk7Evq3pXBjFSfIkvlSorujIDnC8nMW8xJ4py8jOnTRmLAY0a";
    public static final String ENCRYPT_368 = "Req6sSrMS1W7kEfkSqSr7IdGfvmmvMMreg4573f17vXson5J89oALM6vRy7WKB8t17BGclBEOWmR1VGh5ZigY7CxyHaY6HLwEEMyeCxY1rphYjwKHnCit4DygWXdpsdrTvDMbZF6YBjj5cu6MuRgZpQjVbq9GRqEW4AT9zU0uw1Hm8mWNNtckRa5avkb46HU7kfAs5qpawi2ENNW3ASI6inhv7JKzT13ZlVZOiu6DJI3J5Z0u9ToKqvWa4NQbt4fvqAssggcyESAjNkbzoZ9cMcJfnaGt24wHajIWjYjKUaSyTgTvdsn0eqzEeOD0cJ0UJEXqTwzi1IcniMQvWBjUVIci9E74CEr9s4VMlagdcwpjR0H";
    public static final String ENCRYPT_460 = "DGmOGJ1XXyFtiKOAiqpxivxl3ui9RFdypzyB074xZ5xKpteXklA8ylPMxEdM83pJ3xs6qJujAgJRje7CZp9moZ6ZUdpammDu7dlZMll9ZfwTZazeRm2fPc53TJ67ZYJAR4pSoe9vw20499HujJrAsVqAV2sUu1jWEsV5bESqunj09zunwIEZnK5nnAlYGlXJYfyoo1jWMH8UY6DQ2cCySUMBNOO9ZQOwOxNUqG5gKS2gXQlc6jtk8G6B0Lp3LDJ186rFeMeFtO15T8rtyni3F33ZvYLUq98ggo7344sX6Qzu2hYsH2W4XU0bF0Tw6ATwxriPeSyZJJgYwMkzI2wjfZbkUAcRbObRYWFXhFVjpTDi4xFiElO1J93H0QT8NgAa9EuwNrdmvuUmh1VTOqyIk4QIjP9X6SH7g4W1s8W21gHjnlLXvthWRCkbCSztVp4pXsVMtduMH5tZ";
}
