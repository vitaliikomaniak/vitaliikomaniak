package com.vitalii.komaniak.data.remote.mappers.config

import com.vitalii.komaniak.data.remote.model.OneTrustResponse
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.domain.model.app_config.OneTrustAnalytics

class OneTrustDataMapper : DataMapper<OneTrustResponse, OneTrustAnalytics>() {

    override fun OneTrustResponse.fromDto(): OneTrustAnalytics {
        return OneTrustAnalytics(
            oneTrustAppId = this.oneTrustAppId,
        )
    }
}