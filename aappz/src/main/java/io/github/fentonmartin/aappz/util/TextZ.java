package io.github.fentonmartin.aappz.util;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextZ {
    public static boolean isEmailValid(String email) {
        String expression = "^[\\w.\\-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean isPasswordValid(String password, int min) {
        return password != null && password.length() >= min;
    }
    public static boolean isTextMatch(String text1, String text2) {
        return Arrays.equals(new String[]{text1}, new String[]{text2});
    }
    public static boolean isTextContain(String text, String contain) {
        if (contain.equals(""))
            return true;
        if (text == null || text.equals(""))
            return false;
        Pattern pattern = Pattern.compile(contain, Pattern.CASE_INSENSITIVE + Pattern.LITERAL);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
    public static String getNumberClear(String number) {
        return number.replaceAll("\\D+", "");
    }
    public static String getNumberFormat(String number) {
        if (number.isEmpty())
            return "0";
        else
            return NumberFormat.getNumberInstance(Locale.GERMAN).format(Integer.parseInt(number));
    }
    public static int getNumberRandom() {
        return (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
    }
    public static String setFormatMoney(String number) {
        if (number.isEmpty())
            return "Rp 0";
        else
            return "Rp " + NumberFormat.getNumberInstance(Locale.GERMAN).format(Integer.parseInt(number));
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String setFormatName(String name) {
        final int sl = name.length();
        final StringBuilder sb = new StringBuilder(sl);
        boolean lod = false;
        for (int s = 0; s < sl; s++) {
            final int cp = name.codePointAt(s);
            sb.appendCodePoint(lod ? Character.toLowerCase(cp) : Character.toUpperCase(cp));
            lod = Character.isLetterOrDigit(cp);
            if (!Character.isBmpCodePoint(cp)) s++;
        }
        return sb.toString();
    }
    public static String[] convertStringToArray(String inputString, int n) {
        int total = inputString.length() / n;
        int rest = inputString.length() - (total * n);
        if (rest > 0)
            total = total + rest;

        String[] b = new String[total];
        for (int i = 0; i < total; i++) {
            try {
                b[i] = inputString.substring(i * n, i * n + n);
            } catch (StringIndexOutOfBoundsException e) {
                b[i] = inputString.substring(i * n, inputString.length());
            }
        }
        return b;
    }
}