package com.vitalii.komaniak.data.remote.model.content_compiler

import com.google.gson.annotations.SerializedName
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerModule

data class ContentCompilerResponse(
    @SerializedName("data") val data: ContentCompilerModule?,
    @SerializedName("status") val status: Int?,
    @SerializedName("success") val success: Boolean?,
    @SerializedName("error") val error: String?
)