package io.github.fentonmartin.aappz.util;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.github.fentonmartin.aappz.constant.DateConstant;

@SuppressLint("SimpleDateFormat")
public class DateZ {
    public static String getDatetime() {
        return new SimpleDateFormat(DateConstant.DATE_FULL).format(new Date());
    }
    public static String getDatetime(String pattern) {
        return new SimpleDateFormat(pattern).format(new Date());
    }
    public static String getDatetimeSimple() {
        return new SimpleDateFormat().format(new Date());
    }
}
