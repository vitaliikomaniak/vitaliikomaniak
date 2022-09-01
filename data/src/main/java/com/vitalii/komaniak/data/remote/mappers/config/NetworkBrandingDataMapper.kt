package com.vitalii.komaniak.data.remote.mappers.config

import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.NetworkBrandingResponse
import com.vitalii.komaniak.domain.model.app_config.NetworkBranding

class NetworkBrandingDataMapper : DataMapper<NetworkBrandingResponse, NetworkBranding>() {

    override fun NetworkBrandingResponse.fromDto(): NetworkBranding {
        return NetworkBranding(
            logo = this.logo,
            placeholders = PlaceHoldersDataMapper().convert(this.placeholders)
        )
    }
}