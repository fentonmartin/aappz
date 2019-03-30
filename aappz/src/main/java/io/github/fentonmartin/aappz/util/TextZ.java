package io.github.fentonmartin.aappz.util;

import android.text.TextUtils;
import android.util.Patterns;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"WeakerAccess", "unused"})
public class TextZ {

    /**
     * Check email is valid
     *
     * @param email parameter for text matcher
     */
    public static boolean isEmailValid(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * Check phone number is valid
     *
     * @param phone parameter for text matcher
     */
    public static boolean isPhoneValid(String phone) {
        return !TextUtils.isEmpty(phone) && Patterns.PHONE.matcher(phone).matches();
    }

    /**
     * Check text length is below the parameter
     *
     * @param text text/password is being checked
     * @param min  minimum length
     */
    public static boolean isTextLength(String text, int min) {
        return text != null && text.length() >= min;
    }

    /**
     * Check text length is between the parameter
     *
     * @param text text/password is being checked
     * @param min  minimum length
     * @param max  maximum length
     */
    public static boolean isTextLength(String text, int min, int max) {
        return text != null && text.length() >= min && text.length() <= max;
    }

    /**
     * Check text is matched
     *
     * @param text1 first text
     * @param text2 second text
     */
    public static boolean isTextMatch(String text1, String text2) {
        return Arrays.equals(new String[]{text1}, new String[]{text2});
    }

    /**
     * Check text is contained in another text
     *
     * @param text    sentence/long text/base text
     * @param contain contained text is being checked
     */
    public static boolean isTextContain(String text, String contain) {
        if (contain.equals(""))
            return true;
        if (text == null || text.equals(""))
            return false;
        Pattern pattern = Pattern.compile(contain, Pattern.CASE_INSENSITIVE + Pattern.LITERAL);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    /**
     * Get number only string
     *
     * @param number text is being number checked
     */
    public static String getNumberClear(String number) {
        return number.replaceAll("\\D+", "");
    }

    /**
     * Get number formatted string
     *
     * @param number text is being number checked
     */
    public static String getNumberFormat(String number) {
        if (number.isEmpty())
            return "0";
        else
            return NumberFormat.getNumberInstance(Locale.GERMAN).format(Integer.parseInt(number));
    }

    /**
     * Get random integer number
     */
    public static int getNumberRandom() {
        return (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
    }

    /**
     * Get money formatted string
     *
     * @param number text is being checked
     */
    public static String setFormatMoney(String number) {
        if (number.isEmpty())
            return "Rp 0";
        else
            return "Rp " + NumberFormat.getNumberInstance(Locale.GERMAN).format(Integer.parseInt(number));
    }

    /**
     * Get name formatted string
     *
     * @param name text is being checked
     */
    public static String setFormatName(String name) {
        String c = (name != null) ? name.trim() : "";
        String[] words = c.replaceAll("\\s{2,}", " ")
                .split(" ");
        StringBuilder result = new StringBuilder();
        for (String w : words) {
            result.append(w.length() > 1 ? w.substring(0, 1).toUpperCase(Locale.US) + w.substring(1).toLowerCase(Locale.US) : w)
                    .append(" ");
        }
        return result.toString().trim();
    }

    /**
     * Get array string char from inputted text
     *
     * @param text text is being inputted
     */
    public static String[] convertStringToArrayChar(String text) {
        return convertStringToArray(text, 1);
    }

    /**
     * Get array string from inputted text
     *
     * @param text text is being inputted
     * @param n    number of length
     */
    public static String[] convertStringToArray(String text, int n) {
        int total = text.length() / n;
        int rest = text.length() - (total * n);
        if (rest > 0)
            total = total + rest;

        String[] b = new String[total];
        for (int i = 0; i < total; i++) {
            try {
                b[i] = text.substring(i * n, i * n + n);
            } catch (StringIndexOutOfBoundsException e) {
                b[i] = text.substring(i * n, i * n + rest);
            }
        }
        return b;
    }

    /**
     * Get array char from inputted text
     *
     * @param text text is being inputted
     */
    public static char[] convertStringToArray(String text) {
        return text.toCharArray();
    }

    /**
     * Join string from inputted text list by comma
     *
     * @param list the List<String>
     */
    public static String join(List<String> list) {
        return join(list, ",");
    }

    /**
     * Join string from inputted text list
     *
     * @param list      the List<String>
     * @param delimiter the delimiter
     */
    public static String join(List<String> list, String delimiter) {
        return TextUtils.join(delimiter, list);
    }

    /**
     * Split List<String> from inputted text by comma
     *
     * @param text the inputted text
     */
    public static List<String> split(String text) {
        return split(text, ",");
    }

    /**
     * Split List<String> from inputted text
     *
     * @param text      the inputted text
     * @param delimiter the delimiter
     */
    public static List<String> split(String text, String delimiter) {
        List<String> list = new ArrayList<>();
        if (!text.isEmpty())
            list = Arrays.asList(TextUtils.split(text, delimiter));
        return list;
    }
}