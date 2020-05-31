package io.github.fentonmartin.aappz;

import android.text.TextUtils;
import android.util.Patterns;

import java.text.DecimalFormat;
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
     * @return the result
     */
    public static boolean isEmailValid(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * Check phone number is valid
     *
     * @param phone parameter for text matcher
     * @return the result
     */
    public static boolean isPhoneValid(String phone) {
        return !TextUtils.isEmpty(phone) && Patterns.PHONE.matcher(phone).matches();
    }

    /**
     * Check text length is below the parameter
     *
     * @param text text/password is being checked
     * @param min  minimum length
     * @return the result
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
     * @return the result
     */
    public static boolean isTextLength(String text, int min, int max) {
        return text != null && text.length() >= min && text.length() <= max;
    }

    /**
     * Check text is matched
     *
     * @param text1 first text
     * @param text2 second text
     * @return the result
     */
    public static boolean isTextMatch(String text1, String text2) {
        return Arrays.equals(new String[]{text1}, new String[]{text2});
    }

    /**
     * Check text is contained in another text
     *
     * @param text    sentence/long text/base text
     * @param contain contained text is being checked
     * @return the result
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
     * Get decimal formatted string
     *
     * @param number is being number formatted
     * @param digits the maximum fraction digits
     * @return the result
     */
    public static String getDecimalFormat(int number, int digits) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(digits);
        return decimalFormat.format(number);
    }

    /**
     * Get decimal formatted string
     *
     * @param number is being number formatted
     * @param digits the maximum fraction digits
     * @return the result
     */
    public static String getDecimalFormat(float number, int digits) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(digits);
        return decimalFormat.format(number);
    }

    /**
     * Get decimal formatted string
     *
     * @param number is being number formatted
     * @param digits the maximum fraction digits
     * @return the result
     */
    public static String getDecimalFormat(double number, int digits) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(digits);
        return decimalFormat.format(number);
    }

    /**
     * Get decimal formatted string
     *
     * @param number is being number formatted
     * @param digits the maximum fraction digits
     * @return the result
     */
    public static String getDecimalFormat(long number, int digits) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(digits);
        return decimalFormat.format(number);
    }

    /**
     * Get number only string
     *
     * @param text text is being number checked
     * @return the result
     */
    public static String getNumber(String text) {
        return text.replaceAll("\\D+", "");
    }

    /**
     * Get number formatted string
     *
     * @param text text is being number checked
     * @return the result
     */
    public static String getNumberFormat(String text) {
        return getNumberFormat(getNumber(text), false);
    }

    /**
     * Get number formatted string with thousand delimiter (comma/dot)
     *
     * @param text            text is being number formatted
     * @param isUseDotSeparator set thousand separator default = false (comma)
     * @return the result
     */
    public static String getNumberFormat(String text, boolean isUseDotSeparator) {
        if (text.isEmpty())
            return "0";
        else if (isUseDotSeparator)
            return NumberFormat.getNumberInstance(Locale.GERMAN).format(Long.parseLong(getNumber(text)));
        else
            return NumberFormat.getNumberInstance(Locale.ENGLISH).format(Long.parseLong(getNumber(text)));
    }

    /**
     * Get random integer number
     *
     * @return the result
     */
    public static int getNumberRandom() {
        return (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
    }

    /**
     * Get money formatted string (use IDR currency)
     *
     * @param number text is being checked
     * @return the result
     */
    public static String getMoneyFormat(String number) {
        return getMoneyFormat("Rp ", number, false);
    }

    /**
     * Get money formatted string
     *
     * @param currency custom pre-currency (before number)
     * @param number   text is being checked
     * @return the result
     */
    public static String getMoneyFormat(String currency, String number) {
        return getMoneyFormat(currency, number, false);
    }

    /**
     * Get money formatted string
     *
     * @param currency     custom pre-currency (before number)
     * @param number       text is being checked
     * @param postCurrency custom post-currency (after number)
     * @return the result
     */
    public static String getMoneyFormat(String currency, String number, String postCurrency) {
        return getMoneyFormat(currency, number, postCurrency, false);
    }

    /**
     * Get money formatted string (use IDR currency)
     *
     * @param number            text is being checked
     * @param isUseDotSeparator set thousand separator default = false (comma)
     * @return the result
     */
    public static String getMoneyFormat(String number, boolean isUseDotSeparator) {
        return "Rp " + getNumberFormat(number, isUseDotSeparator);
    }

    /**
     * Get money formatted string
     *
     * @param currency          custom pre-currency (before number)
     * @param number            text is being checked
     * @param isUseDotSeparator set thousand separator default = false (comma)
     * @return the result
     */
    public static String getMoneyFormat(String currency, String number, boolean isUseDotSeparator) {
        return currency + getNumberFormat(number, isUseDotSeparator);
    }

    /**
     * Get money formatted string
     *
     * @param currency          custom pre-currency (before number)
     * @param number            text is being checked
     * @param postCurrency      custom post-currency (after number)
     * @param isUseDotSeparator set thousand separator default = false (comma)
     * @return the result
     */
    public static String getMoneyFormat(String currency, String number, String postCurrency, boolean isUseDotSeparator) {
        return currency + getNumberFormat(number, isUseDotSeparator) + postCurrency;
    }

    /**
     * Get space and enter formatted string (remove doubled spaces)
     *
     * @param text text is being checked
     * @return the result
     */
    public static String getFormatAll(String text) {
        return getFormatName(getFormatSpace(getFormatEnter(text)));
    }

    /**
     * Get name formatted string
     *
     * @param name text is being checked
     * @return the result
     */
    public static String getFormatName(String name) {
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
     * Get space formatted string (remove doubled spaces)
     *
     * @param text text is being checked
     * @return the result
     */
    public static String getFormatSpace(String text) {
        return text.replaceAll("\\s{2,}", " ");
    }

    /**
     * Get space formatted string (remove doubled spaces)
     *
     * @param text text is being checked
     * @return the result
     */
    public static String getFormatEnter(String text) {
        return text.replaceAll("\\n{2,}", "\n");
    }

    /**
     * Get array string char from inputted text
     *
     * @param text text is being inputted
     * @return the result
     */
    public static String[] getArrayCharFrom(String text) {
        return getArrayFrom(text, 1);
    }

    /**
     * Get array string from inputted text
     *
     * @param text text is being inputted
     * @param n    number of length
     * @return the result
     */
    public static String[] getArrayFrom(String text, int n) {
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
     * @return the result
     */
    public static char[] getArrayFrom(String text) {
        return text.toCharArray();
    }

    /**
     * Join string from inputted text list by comma
     *
     * @param list the String List
     * @return the result
     */
    public static String getStringFrom(List<String> list) {
        return getStringFrom(list, ",");
    }

    /**
     * Join string from inputted text list
     *
     * @param list      the String List
     * @param delimiter the delimiter
     * @return the result
     */
    public static String getStringFrom(List<String> list, String delimiter) {
        return TextUtils.join(delimiter, list);
    }

    /**
     * Split List from inputted text by comma
     *
     * @param text the inputted text
     * @return the result
     */
    public static List<String> getListFrom(String text) {
        return getListFrom(text, ",");
    }

    /**
     * Split List from inputted text
     *
     * @param text      the inputted text
     * @param delimiter the delimiter
     * @return the result
     */
    public static List<String> getListFrom(String text, String delimiter) {
        List<String> list = new ArrayList<>();
        if (!text.isEmpty())
            list = Arrays.asList(TextUtils.split(text, delimiter));
        return list;
    }
}