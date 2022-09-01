package com.vitalii.komaniak.data.remote.api

interface RestHttpClient {

    suspend fun get(url: String): String

    suspend fun get(url: String, headers: Map<String, String>?): String

    suspend fun post(url: String, requestBody: Map<String, Any>?): String

    suspend fun post(
        url: String,
        headers: Map<String, String>?,
        requestBody: Map<String, Any>?,
    ): String

    suspend fun delete(url: String)
}