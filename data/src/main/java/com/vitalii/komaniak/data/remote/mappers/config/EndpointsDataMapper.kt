package com.vitalii.komaniak.data.remote.mappers.config

import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.EndpointsResponse
import com.vitalii.komaniak.domain.model.app_config.Endpoints

class EndpointsDataMapper : DataMapper<EndpointsResponse, Endpoints>() {
    override fun EndpointsResponse.fromDto(): Endpoints {
        return Endpoints(
            webSite = this.webSiteUrl ?: "url.com",
            baseUrl = this.baseUrl,
            compilerUrl = this.compilerUrl,
            mocksUrl = this.mocksUrl,
            stylingUrl = this.stylingUrl,
            bookmarkServiceUrl = this.bookmarksUrl,
            bookmarkAddUrl = this.bookmarksAddBaseUrl,
            authBaseUrl = this.authUrl,
            mvpdUrl = null,
            myStuffUrl = this.myStuffUrl,
            messagesUrl = this.messagesUrl,
            manifestUrl = this.manifestUrl,
            userManifestUrl = this.userManifestUrl,
            geolocationUrl = this.geolocationUrl,
            accountIdUrl = this.accountIdUrl,
        )
    }
}