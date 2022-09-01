package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ContentCompilerDownloadData(
    @SerialName("callback") val callback: ContentCompilerCallback?,
    @SerialName("downloadable") val downloadable: Boolean?,
    @SerialName("downloadingExpireIn") val downloadingExpireIn: Long?,
    @SerialName("downloadingEndDate") val downloadingEndDate: Long?,
)