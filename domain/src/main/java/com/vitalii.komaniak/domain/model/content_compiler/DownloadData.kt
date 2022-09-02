package com.vitalii.komaniak.domain.model.content_compiler

import com.vitalii.komaniak.domain.model.content_compiler.Callback

data class DownloadData(
    val callback: Callback?,
    val downloadable: Boolean?,
    val downloadingExpireIn: Long?,
    val downloadingEndDate: Long?,
    val expired: Boolean = false,
    val expiresIn: Long? = null,
)