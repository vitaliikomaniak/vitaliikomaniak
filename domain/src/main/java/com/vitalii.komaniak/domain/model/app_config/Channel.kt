package com.vitalii.komaniak.domain.model.app_config

data class Channel(
    val fullName: String? = null,
    val alias: String? = null,
    val serviceId: String? = null,
    val serviceGroupId: String? = null,
    val networkBranding: NetworkBranding? = null,
)