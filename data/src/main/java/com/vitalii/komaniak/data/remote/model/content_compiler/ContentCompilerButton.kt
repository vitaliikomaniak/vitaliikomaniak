package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentCompilerButton(
        @SerialName("type") val type: String?,
        @SerialName("state") val state: ContentCompilerButtonState?,
        @SerialName("properties") val properties: ContentCompilerButtonProperties?,
)
