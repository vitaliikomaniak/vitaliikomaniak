package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentCompilerResponse(
    @SerialName("data") val data: ContentCompilerModule?,
    @SerialName("status") val status: Int?,
    @SerialName("success") val success: Boolean?,
    @SerialName("error") val error: String?
)