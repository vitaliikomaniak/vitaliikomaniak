package com.vitalii.komaniak.data.remote.api

import io.ktor.client.statement.*

interface RestHttpClient {

    suspend fun get(url: String): String

    suspend fun post(url: String, requestBody: Map<String, Any>): HttpResponse

    suspend fun delete(url: String)
}