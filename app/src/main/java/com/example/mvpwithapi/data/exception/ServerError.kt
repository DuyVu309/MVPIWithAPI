package com.example.mvpwithapi.data.exception

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ServerError(
    @Expose
    @SerializedName("success")
    var success: Boolean?,

    @Expose
    @SerializedName("message")
    var message: String,

    @Expose
    @SerializedName("status")
    var status: Int?
)