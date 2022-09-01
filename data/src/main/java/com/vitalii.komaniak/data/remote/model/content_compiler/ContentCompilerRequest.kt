package com.vitalii.komaniak.data.remote.model.content_compiler

import com.google.gson.annotations.SerializedName

data class ContentCompilerRequest(
    @SerializedName("endpoint") val endpoint: String?,
)