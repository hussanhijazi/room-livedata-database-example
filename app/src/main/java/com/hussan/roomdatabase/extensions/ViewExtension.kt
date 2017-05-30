package com.hussan.roomdatabase.extensions

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(key: String? = null): T {
    val provider = ViewModelProviders.of(this)
    return if (key != null) {
        provider.get(key, T::class.java)
    } else {
        provider.get(T::class.java)
    }
}