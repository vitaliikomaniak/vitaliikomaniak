package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentCompilerNavigation(
    @SerialName("micro_app_type"
       // , alternate = ["type"]
    ) val microAppType: String?,
    @SerialName("action") val action: String?,
    @SerialName("extras") val extras: Extras?,
    @SerialName("properties") val properties: ContentCompilerNavigationProperties?,
    @SerialName(value = "request"
       // , alternate = ["client_request"]
    ) val request: ContentCompilerNavigationRequest?,
) {
    @Serializable
    data class ContentCompilerNavigationProperties(
        @SerialName("nid") val nid: Int?,
        @SerialName("fullscreen") val fullscreen: Boolean?,
        @SerialName("isModal") val isModal: Boolean?,
        @SerialName("fullScreenMode") val fullScreenMode: String?,
    )

    @Serializable
    data class ContentCompilerNavigationRequest(
        @SerialName("endpoint") val endpoint: String?,
        @SerialName("website") val website: String?,
        @SerialName("ios") val ios: String?,
        @SerialName("android") val android: String?
    )
}