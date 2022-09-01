package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentCompilerDiImages(
    @SerialName("height_80px") val height80px: String?,
    @SerialName("height_120px") val height120px: String?
)