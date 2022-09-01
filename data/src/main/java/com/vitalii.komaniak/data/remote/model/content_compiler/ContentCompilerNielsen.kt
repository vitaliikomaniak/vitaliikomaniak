package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentCompilerNielsen(
    @SerialName("nielsenSummaryTypeCode") val nielsenSummaryTypeCode: String? = null,
    @SerialName("adloadtype") val adloadtype: String? = null,
    @SerialName("type") val type: String? = null,
)