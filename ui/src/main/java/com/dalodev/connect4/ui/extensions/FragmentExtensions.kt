package com.dalodev.connect4.ui.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showShortToast(message: CharSequence): Toast {
    return requireContext().showShortToast(message)
}

fun Fragment.showLongToast(message: CharSequence): Toast {
    return requireContext().showLongToast(message)
}