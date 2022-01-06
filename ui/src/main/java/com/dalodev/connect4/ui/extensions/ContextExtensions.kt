/*
 * Copyright 2021 dalodev
 */
package com.dalodev.connect4.ui.extensions

import android.content.Context
import android.widget.Toast

fun Context.showShortToast(message: CharSequence): Toast {
    return showToast(message, duration = Toast.LENGTH_SHORT)
}

fun Context.showLongToast(message: CharSequence): Toast {
    return showToast(message, duration = Toast.LENGTH_LONG)
}

fun Context.showToast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT): Toast {
    return Toast.makeText(this, message, duration)
        .apply { show() }
}