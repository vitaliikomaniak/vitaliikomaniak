package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentCompilerCallback(
    @SerialName("type") val type: String?,
    @SerialName("name") val name: String?,
    @SerialName(value = "endpoint") val endpoint: String?,
)