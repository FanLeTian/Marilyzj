package com.abc.marilyzj.util;

import android.content.Context;

/**
 * Created by acer on 2017/3/13.
 */

public class PhoneNumberEncryptUtil {

    public static String encryptPhone(Context context) {
        return SharedPreferencesUtil.getPrefString(context,"phoneNumber", "").replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }
}
