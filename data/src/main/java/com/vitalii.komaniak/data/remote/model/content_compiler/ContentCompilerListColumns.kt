package com.vitalii.komaniak.data.remote.model.content_compiler

import com.google.gson.annotations.SerializedName

data class ContentCompilerListColumns(
    @SerializedName("mobile_portrait") val mobilePortrait: Int?,
    @SerializedName("tablet_portrait") val tabletPortrait: Int?,
    @SerializedName("tablet_landscape") val tabletLandscape: Int?,
    @SerializedName("ott") val ott: Int?,
)