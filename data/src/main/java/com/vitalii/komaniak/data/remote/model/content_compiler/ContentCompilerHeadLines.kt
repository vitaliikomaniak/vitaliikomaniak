package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentCompilerHeadLines(
    @SerialName("slot1") val slot1: ContentCompilerHeadLinesText?,
    @SerialName("slot2") val slot2: ContentCompilerHeadLinesText?,
    @SerialName("description") val description: ContentCompilerHeadLinesText?,
    @SerialName("badge") val badge: ContentCompilerBadge?,
) {
    @Serializable
    data class ContentCompilerHeadLinesText(
        @SerialName("text") val text: String?,
        @SerialName("hasTitleDivider") val hasTitleDivider: Boolean?,
    )
}