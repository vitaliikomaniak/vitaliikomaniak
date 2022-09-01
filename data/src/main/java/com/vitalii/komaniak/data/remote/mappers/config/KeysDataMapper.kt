package com.vitalii.komaniak.data.remote.mappers.config

import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.KeysResponse
import com.vitalii.komaniak.domain.model.app_config.Keys

class KeysDataMapper : DataMapper<KeysResponse, Keys>() {

    override fun KeysResponse.fromDto(): Keys {
        return Keys(
            chromecastReceiverAppId = chromeCastReceiverAppId,
            bcAccountId = bcAccountId,
            bcPlayerId = bcPlayerId
        )
    }
}