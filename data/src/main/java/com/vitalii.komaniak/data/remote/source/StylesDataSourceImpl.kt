package com.vitalii.komaniak.data.remote.source

import com.vitalii.komaniak.data.remote.StylesDataSource
import com.vitalii.komaniak.data.remote.api.RestHttpClient

class StylesDataSourceImpl(private val restApiClient: RestHttpClient): StylesDataSource {

    override suspend fun loadStyles(stylesUrl: String) {
        //restApiClient.loadStyles(stylesUrl = stylesUrl)
    }
}