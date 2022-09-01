package com.vitalii.komaniak.data.remote.mappers.config

import com.vitalii.komaniak.data.remote.model.YouboraResponse
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.domain.model.app_config.YouboraAnalytics

class YouboraDataMapper : DataMapper<YouboraResponse, YouboraAnalytics>() {

    override fun YouboraResponse.fromDto(): YouboraAnalytics {
        return YouboraAnalytics(
            youboraAppId = this.youboraAppId,
            youboraNetworkId = this.youboraNetworkId
        )
    }
}