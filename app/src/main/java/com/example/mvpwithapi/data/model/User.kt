package com.example.mvpwithapi.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @Expose
    @SerializedName("password")
    var password: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null) : Parcelable