package com.vitalii.komaniak.data.remote.mappers.config

import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.ComScoreResponse
import com.vitalii.komaniak.domain.model.app_config.ComScoreAnalytics

class ComScoreDataMapper : DataMapper<ComScoreResponse, ComScoreAnalytics>() {

    override fun ComScoreResponse.fromDto(): ComScoreAnalytics {
        return ComScoreAnalytics(
            comScoreAccountId = this.comScoreAccountId,
        )
    }
}