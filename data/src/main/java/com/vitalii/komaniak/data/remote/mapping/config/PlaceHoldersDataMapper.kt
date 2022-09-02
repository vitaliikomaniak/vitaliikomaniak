package com.vitalii.komaniak.data.remote.mapping.config

import com.vitalii.komaniak.data.remote.model.PlaceholdersResponse
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.domain.model.app_config.Placeholders

class PlaceHoldersDataMapper : DataMapper<PlaceholdersResponse, Placeholders>() {

    override fun PlaceholdersResponse.fromDto(): Placeholders {
        return Placeholders(
            poster = this.poster,
            square = this.square,
            wide = this.wide,
            ultraWide = this.ultraWide
        )
    }
}