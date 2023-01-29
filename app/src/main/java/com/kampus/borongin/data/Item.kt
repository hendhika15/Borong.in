package com.kampus.borongin.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    var number: String,
    var foto: Int
    ) : Parcelable