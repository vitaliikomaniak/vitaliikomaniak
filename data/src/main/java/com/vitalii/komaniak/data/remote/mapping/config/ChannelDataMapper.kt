package com.vitalii.komaniak.data.remote.mapping.config

import com.vitalii.komaniak.data.remote.model.ChannelResponse
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.domain.model.app_config.Channel

class ChannelDataMapper : DataMapper<ChannelResponse, Channel>() {

    override fun ChannelResponse.fromDto(): Channel {
        return Channel(
            fullName = this.fullName.toString(),
            alias = this.alias.toString(),
            serviceId = this.serviceID,
            serviceGroupId = this.serviceGroupID,
            networkBranding = NetworkBrandingDataMapper().convertNullable(this.networkBranding)
        )
    }
}