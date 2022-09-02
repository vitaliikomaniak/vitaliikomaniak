package com.vitalii.komaniak.data.remote.repository

import com.vitalii.komaniak.domain.repository.Repository

class RequestHeadersRepositoryImpl : Repository<String, Map<String, String>> {

    override suspend fun read(input: String): Map<String, String> {
        val headers = mutableMapOf<String, String>()
        headers["X-AMCN-DEVICE-ID"] = "d487bbba-d626-4aa7-9564-d0b366838a5c"
        headers["X-AMCN-LANGUAGE"] = "en"
        headers["X-AMCN-NETWORK"] = "amcplus"
        headers["X-AMCN-PLATFORM"] = "android"
        headers["X-AMCN-TENANT"] = "amcn"
        headers["X-AMCN-AUDIENCE-ID"] = "amcn"
        headers["X-AMCN-SERVICE-ID"] = "amcplus"
        headers["X-AMCN-SERVICE-GROUP-ID"] = "10"

        return headers
    }
}