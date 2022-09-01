package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentCompilerInput(
        @SerialName("secure") val secure: Boolean?,
        @SerialName("text") val textFields: ContentCompilerTextFields?
)

