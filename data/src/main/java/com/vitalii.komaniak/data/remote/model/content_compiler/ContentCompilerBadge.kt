package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ContentCompilerBadge (
    @SerialName("type") val type: String?,
    @SerialName("title") val title: String?,
    @SerialName("icon") val icon: String?,
    @SerialName("url") val url: String?
)