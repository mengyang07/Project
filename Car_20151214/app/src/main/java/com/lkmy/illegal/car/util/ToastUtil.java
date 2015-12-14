package com.lkmy.illegal.car.util;

import android.support.annotation.StringRes;
import android.widget.Toast;

import com.lkmy.illegal.car.App;


/**
 * 作者:李凯
 * 创建时间:2015/11/13 00:15
 * 描述:
 */
public class ToastUtil {

    private ToastUtil() {
    }

    public static void show(CharSequence text) {
        if (text.length() < 10) {
            Toast.makeText(App.getInstance(), text, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(App.getInstance(), text, Toast.LENGTH_LONG).show();
        }
    }

    public static void show(@StringRes int resId) {
        show(App.getInstance().getString(resId));
    }

}