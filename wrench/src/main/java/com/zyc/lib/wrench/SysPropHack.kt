@file:SuppressLint("PrivateApi")

package com.zyc.lib.wrench

import android.annotation.SuppressLint
import android.text.TextUtils

/**
 * @author devzyc
 */
fun stringCliProp(
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

fun intCliProp(
    key: String,
    defaultValue: Int
): Int {
    return stringCliProp(key, defaultValue.toString())
        .toInt()
}

fun longCliProp(
    key: String,
    defaultValue: Long
): Long {
    return stringCliProp(key, defaultValue.toString())
        .toLong()
}

fun booleanCliProp(
    key: String,
    defaultValue: Boolean
): Boolean {
    return stringCliProp(key, defaultValue.toString())
        .toBoolean()
}


