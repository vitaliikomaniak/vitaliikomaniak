package com.vitalii.komaniak.data.remote.mappers.config

import com.vitalii.komaniak.data.remote.model.AnalyticsResponse
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.domain.model.app_config.Analytics

class AnalyticsDataMapper : DataMapper<AnalyticsResponse, Analytics>() {

    override fun AnalyticsResponse.fromDto(): Analytics {
        return Analytics(
            oneTrust = OneTrustDataMapper().convertNullable(this.oneTrust),
            youbora = YouboraDataMapper().convertNullable(this.youbora),
            comScore = ComScoreDataMapper().convertNullable(this.comScore)
        )
    }
}