package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentCompilerKeys(
    @SerialName("id") val id: String?,
    @SerialName("settingName") val settingName: String?,
    @SerialName("settingValue") val settingValue: String?
)