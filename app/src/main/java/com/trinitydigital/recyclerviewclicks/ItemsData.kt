package com.trinitydigital.recyclerviewclicks

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemsData (
    var title: String,
    var desc: String
): Parcelable