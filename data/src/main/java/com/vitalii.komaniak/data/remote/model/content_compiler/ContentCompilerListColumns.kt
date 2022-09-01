package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentCompilerListColumns(
    @SerialName("mobile_portrait") val mobilePortrait: Int?,
    @SerialName("tablet_portrait") val tabletPortrait: Int?,
    @SerialName("tablet_landscape") val tabletLandscape: Int?,
    @SerialName("ott") val ott: Int?,
)