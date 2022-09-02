package com.vitalii.komaniak.data.remote.repository

import com.vitalii.komaniak.data.common.Environment
import com.vitalii.komaniak.domain.repository.Repository

class RequestHeadersRepositoryImpl(private val environment: Environment) :
    Repository<String, Map<String, String>> {

    override suspend fun read(input: String): Map<String, String> {
        val headers = mutableMapOf<String, String>()
        headers[X_AMCN_DEVICE_ID] = environment.getDeviceUUID()
        headers[X_AMCN_LANGUAGE] = environment.getLanguage()
        headers[X_AMCN_NETWORK] = "amcplus"
        headers[X_AMCN_PLATFORM] = environment.getPlatform()
        headers[X_AMCN_TENANT] = "amcn"
        headers[X_AMCN_AUDIENCE_ID] = "amcn"
        headers[X_AMCN_SERVICE_ID] = "amcplus"
        headers[X_AMCN_SERVICE_GROUP_ID] = "10"

        return headers
    }

    companion object {
        const val X_AMCN_DEVICE_ID = "X-AMCN-DEVICE-ID"
        const val X_AMCN_LANGUAGE = "X-AMCN-LANGUAGE"
        const val X_AMCN_NETWORK = "X-AMCN-NETWORK"
        const val X_AMCN_PLATFORM = "X-AMCN-PLATFORM"
        const val X_AMCN_TENANT = "X-AMCN-TENANT"
        const val X_AMCN_DEVICE_AD_ID = "X-AMCN-DEVICE-AD-ID"
        const val X_AMCN_SERVICE_ID = "X-AMCN-SERVICE-ID"
        const val X_AMCN_SERVICE_GROUP_ID = "X-AMCN-SERVICE-GROUP-ID"
        const val X_AMCN_AUDIENCE_ID = "X-AMCN-AUDIENCE-ID"
        const val X_CCPA_DO_NOT_SELL = "X-CCPA-DO-NOT-SELL"
    }
}