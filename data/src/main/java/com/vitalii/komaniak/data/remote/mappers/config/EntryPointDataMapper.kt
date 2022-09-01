package com.vitalii.komaniak.data.remote.mappers.config

import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.EntryPointResponse
import com.vitalii.komaniak.domain.model.app_config.EntryPoint

class EntryPointDataMapper : DataMapper<EntryPointResponse, EntryPoint>() {

    override fun EntryPointResponse.fromDto(): EntryPoint {
        return EntryPoint(
            microAppType = this.navigation.microAppType,
            endpoint = this.navigation.request.endpoint
        )
    }
}