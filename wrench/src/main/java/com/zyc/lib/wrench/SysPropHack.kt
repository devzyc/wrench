package com.zyc.lib.wrench

import android.annotation.SuppressLint
import android.text.TextUtils

/**
 * @author devzyc
 */
@SuppressLint("PrivateApi")
fun getCliProp(
    key: String,
    defaultValue: String
): String {
    return try {
        val clazz = Class.forName("android.os.SystemProperties")
        val method = clazz.getDeclaredMethod("get", String::class.java)
        val got = method.invoke(null, key) as String
        if (TextUtils.isEmpty(got)) defaultValue else got
    } catch (e: Exception) {
        e.printStackTrace()
        defaultValue
    }
}

@SuppressLint("PrivateApi")
fun getCliProp(
    key: String,
    defaultValue: Int
): Int {
    return getCliProp(key = key, defaultValue = defaultValue.toString())
        .toInt()
}

@SuppressLint("PrivateApi")
fun getCliProp(
    key: String,
    defaultValue: Boolean
): Boolean {
    return getCliProp(key = key, defaultValue = defaultValue.toString())
        .toBoolean()
}


