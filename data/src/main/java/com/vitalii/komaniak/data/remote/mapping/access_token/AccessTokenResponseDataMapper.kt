package com.vitalii.komaniak.data.remote.mapping.access_token

import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.access_token.AccessTokenDataResponse
import com.vitalii.komaniak.domain.model.content_compiler.AccessToken

class AccessTokenResponseDataMapper : DataMapper<AccessTokenDataResponse, AccessToken>() {

    override fun AccessTokenDataResponse.fromDto(): AccessToken {
        return AccessToken(
            accessToken = this.accessToken,
            refreshToken = this.refreshToken,
            expireIn = this.expireIn,
            tokenType = this.tokenType,
            cacheHash = this.cacheHash,
        )
    }
}