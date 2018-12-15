package io.github.fentonmartin.aappz.constant;

import io.github.fentonmartin.aappz.util.TextZ;

public class EncryptConstant {

    public static String ALL = " !@#$%&*()_+=|<>?{}[]~-/0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static String SYMBOLS = "!@#$%&*()_+=|<>?{}[]~-/";

    private static String NUMERIC_ASC = "0123456789";
    private static String NUMERIC_DSC = "9876543210";

    private static String ALPHABET_LOWER_ASC = "abcdefghijklmnopqrstuvwxyz";
    private static String ALPHABET_LOWER_DSC = "zyxwvutsrqponmlkjihgfedcba";

    private static String ALPHABET_UPPER_ASC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String ALPHABET_UPPER_DSC = "ZYXWVUTSRQPONMLKJIHGFEDCBA";

    public static char[] ARRAY_ALL = ALL.toCharArray();
    public static char[] ARRAY_NUMERIC_ASC = NUMERIC_ASC.toCharArray();
    public static char[] ARRAY_NUMERIC_DSC = NUMERIC_DSC.toCharArray();
    public static char[] ARRAY_ALPHABET_LOWER_ASC = ALPHABET_LOWER_ASC.toCharArray();
    public static char[] ARRAY_ALPHABET_LOWER_DSC = ALPHABET_LOWER_DSC.toCharArray();
    public static char[] ARRAY_ALPHABET_UPPER_ASC = ALPHABET_UPPER_ASC.toCharArray();
    public static char[] ARRAY_ALPHABET_UPPER_DSC = ALPHABET_UPPER_DSC.toCharArray();

    public static String ENCRYPT_86 = "5A=Bc|aFZGOJk(ME9KgRILlz}XH%rh/v<73~S-YCqu#@)[yn?s!jU*D>pNiQ$6mP4d0f_T8x]2oWeV1w{&b+t ";
    public static String ENCRYPT_170 = "X8Vi4F6RCPX2cbVazIgunuXsBwE0bb4eReYuqwiUSkvQCLO7jNLCuv3cRi1hmTBxnqiQeObmkEsiXFHk4oIhOwj3BdbOCJ77vpivqQR0Mctxp6yFOUyHEwiWIwdoxVQhacKua6CDDsnE0m0vICITUfgM2XsJr57XmOYfKmtuJN";
    public static String ENCRYPT_255 = "N7L8nwxN1aNIZOWbqeD1VL7JTYqe9q2mPnPzy9ZcL39yTNGaDjEdgb2PZlRN9FcItrFlTYGXkqL5UJfFnKfXwZUnwKmH7tZW9iqK3x7yG5Ul7NEi0T6gmEaUiMRNoXYazy1A9GUMHOtpITyuTJeRhFhjYyZeidiZ8fRqIz9H5xbHha71W5a1AfEPj9KpoWUOquy1xOshXewWW1Fv9jGDDyOnBopCJyaIOxr2KX69qQUgekd3bmlPF4VYxUW14M5";

    public static String[] ARRAY_ENCRYPT_85 = TextZ.convertStringToArray(EncryptConstant.ENCRYPT_86, 1);
    public static String[] ARRAY_ENCRYPT_170 = TextZ.convertStringToArray(EncryptConstant.ENCRYPT_170, 2);
    public static String[] ARRAY_ENCRYPT_255 = TextZ.convertStringToArray(EncryptConstant.ENCRYPT_255, 3);

    public static String ENCRYPT_62 = "5KkR0ZHweNfjCLUp1gA2sSYx4MGhVnOtJI8yWPouXEcb7zmDQlir36aFdBTv9q";
    public static String ENCRYPT_124 = "7YtUbj9ZJzS1DeLbRMqeejFr0PUXzL2uhSAFpXwaf5UJm2f8Dzxn2XF3OU7yIfxdwixJYtLvO7HSRnvuxvq65H3Znq7XPU1HXyrlQfYmH5Vw1m9XpkmQcYmGjAjp";
    public static String ENCRYPT_186 = "1y2U07RBjnWQfwv73g3Hfeq00v1I8SbScbsg1mJbMkswnoRPtTZ6DvCPwyzgE2XsAMiEUmQOm9cg8YsOvGhuIoRRUI1OXL8ZYMhepl8J2H6AxCVRxdbWRgHPaCBcTDA9WjW9l7dsEex5Mpbt1N7xb2tQXi7KRCJ2QvaCKjd0gxcb1N7cUztVub2mW2";
    public static String ENCRYPT_248 = "RjRCziawLCcfkRQHFTV0av91E5iYI3KtL5zlfjY30bsDreq6y0QvxjDjjkXFjkPWOzh5IGUyZlLi9kQmo9o5agZZ1sbGZNLAXXu17vnHq0rk7s7bAzWmIELysQR1Bbwl6NW5LgeR98aCrFhoRxEZIWqachV1PXhyTXsokldxqmUdINQ4HlVd8JXS1DjJlg6BIFAWTkDxKKenS2Oi64gBsbdBLq6L6yMaY3NT5oBHZ3SGMfS1pUf34zYy";

    public static char[] ARRAY_CHAR_ENCRYPT_85 = ENCRYPT_86.toCharArray();

}