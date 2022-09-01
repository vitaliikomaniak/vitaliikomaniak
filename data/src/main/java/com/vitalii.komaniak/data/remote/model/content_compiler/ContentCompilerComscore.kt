package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ContentCompilerComscore(@SerialName("classificationType") val classificationType: String? = null)