package com.vitalii.komaniak.data.remote.repository

import com.vitalii.komaniak.data.remote.StylesDataSource
import com.vitalii.komaniak.domain.repository.StylesRepository

class StylesRepositoryImpl(private val stylesDataSource: StylesDataSource): StylesRepository {

    override suspend fun loadStyles(stylesUrl: String) {
        stylesDataSource.loadStyles(stylesUrl = stylesUrl)
    }
}