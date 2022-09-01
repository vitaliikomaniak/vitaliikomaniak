package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentCompilerCardSize(
    @SerialName("mobile") val mobile: ContentCompilerCardSizeSpec?,
    @SerialName("tablet") val tablet: ContentCompilerTabletCardSize?,
    @SerialName("ott") val ott: ContentCompilerCardSizeSpec?,
) {
    data class ContentCompilerCardSizeSpec(
        @SerialName("cardWidth") val cardWidth: Int?,
        @SerialName("cardHeight") val cardHeight: Int?
    )

    data class ContentCompilerTabletCardSize(
        @SerialName("portrait") val portrait: ContentCompilerCardSizeSpec?,
        @SerialName("landscape") val landscape: ContentCompilerCardSizeSpec?
    )
}