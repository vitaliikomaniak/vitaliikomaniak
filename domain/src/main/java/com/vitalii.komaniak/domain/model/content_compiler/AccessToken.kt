package com.vitalii.komaniak.domain.model.content_compiler

data class AccessToken(
    val accessToken: String,
    val tokenType: String,
    val refreshToken: String,
    val expireIn: Long,
    val cacheHash: String,
)