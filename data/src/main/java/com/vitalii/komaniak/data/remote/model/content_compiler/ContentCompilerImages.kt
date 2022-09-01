package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentCompilerImages(
    @SerialName("mobile") val mobile: String?,
    @SerialName("tablet") val tablet: String?,
    @SerialName("default") val default: String?,
    @SerialName("featured") val featured: String?,
    @SerialName("mode") val mode: String?,
    @SerialName("bg_white") val bgWhite: ContentCompilerDiImages?,
    @SerialName("bg_dark") val bgDark: ContentCompilerDiImages?
)