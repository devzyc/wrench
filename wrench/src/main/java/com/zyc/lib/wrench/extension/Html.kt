package com.zyc.lib.wrench.extension

import android.os.Build
import android.text.Html

fun String.translateHtml(): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY).toString()
    } else {
        this
    }
}