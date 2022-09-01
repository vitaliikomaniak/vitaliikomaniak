package com.vitalii.komaniak.data.remote.api

import android.util.Log
import com.vitalii.komaniak.data.common.TAG
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.observer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json


class RestApiClientImpl : RestHttpClient {

    private val client = HttpClient(Android) {
        val TIME_OUT = 15_000
        install(ContentNegotiation) {
            JsonSerialize
            engine {
                connectTimeout = TIME_OUT
                socketTimeout = TIME_OUT
            }
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.d(RestApiClientImpl::class.java.canonicalName, message)
                }
            }
            level = LogLevel.ALL
        }

        install(ResponseObserver) {
            onResponse { response ->
                Log.d(TAG(), "HTTP status: ${response.status.value}")
            }
        }
    }

    val JsonSerialize = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
        coerceInputValues = true
        encodeDefaults = true
    }

    override suspend fun get(url: String): String {
        val response = client.get(url)
        return response.bodyAsText()
    }

    override suspend fun get(url: String, headers: Map<String, String>?): String {
        val response = client.get(url) {
            headers {
                headers?.forEach {
                    append(it.key, it.value)
                }
            }
        }
        return response.bodyAsText()
    }

    override suspend fun post(url: String, requestBody: Map<String, Any>?): String {
        return client.post(url) {
            requestBody?.let { setBody(it) }
        }.bodyAsText()
    }

    override suspend fun post(
        url: String,
        headers: Map<String, String>?,
        requestBody: Map<String, Any>?,
    ): String {
        return client.post(url) {
            headers {
                headers?.forEach {
                    append(it.key, it.value)
                }
            }
            requestBody?.let { setBody(it) }
        }.bodyAsText()
    }

    override suspend fun delete(url: String) {
        val delete: HttpResponse = client.delete {
            url(url)
        }
    }
}