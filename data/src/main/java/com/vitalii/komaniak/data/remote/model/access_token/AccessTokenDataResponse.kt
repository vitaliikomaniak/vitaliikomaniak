package com.vitalii.komaniak.data.remote.model.access_token

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccessTokenDataResponse(
    @SerialName("access_token") val accessToken: String,
    @SerialName("token_type") val tokenType: String,
    @SerialName("expires_in") val expireIn: Long,
    @SerialName("refresh_token") val refreshToken: String,
    @SerialName("cache_hash") val cacheHash: String,
    @SerialName("user_cache_hash") val user_cache_hash: String,
    @SerialName("code") val code: String,
)