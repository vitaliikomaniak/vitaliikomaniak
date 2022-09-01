package com.vitalii.komaniak.data.remote.model.content_compiler

import com.google.gson.annotations.SerializedName

data class ContentCompilerModule(
    @SerializedName("type") val type: String?,
    @SerializedName("properties") val properties: ContentCompilerProperties?,
    @SerializedName("tablet_properties") val tabletProperties: ContentCompilerProperties?,
    @SerializedName("children") val children: List<ContentCompilerModule?>?,
    @SerializedName(value = "client_request") val request: ContentCompilerNavigation.ContentCompilerNavigationRequest?,
    @SerializedName(value = "callback") val callback: ContentCompilerCallback?,
) {
    fun getModuleOrNull(type: String): ContentCompilerModule? {
        return children?.find { it?.type?.equals(type, true) ?: false }
    }
}
