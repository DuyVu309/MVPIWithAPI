package com.example.mvpwithapi.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(

    @SerializedName("userId")
    @Expose
    var userId: Int? = null,

    @Expose
    @SerializedName("id")
    var id: Int? = null,

    @Expose
    @SerializedName("title")
    var title: String? = null) : Parcelable