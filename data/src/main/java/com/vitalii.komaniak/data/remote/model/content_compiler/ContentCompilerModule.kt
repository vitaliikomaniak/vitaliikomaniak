package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentCompilerModule(
    @SerialName("type") val type: String?,
    @SerialName("properties") val properties: ContentCompilerProperties?,
    @SerialName("tablet_properties") val tabletProperties: ContentCompilerProperties?,
    @SerialName("children") val children: List<ContentCompilerModule?>?,
    @SerialName(value = "client_request") val request: ContentCompilerNavigation.ContentCompilerNavigationRequest?,
    @SerialName(value = "callback") val callback: ContentCompilerCallback?,
) {
    fun getModuleOrNull(type: String): ContentCompilerModule? {
        return children?.find { it?.type?.equals(type, true) ?: false }
    }
}
