package com.vitalii.komaniak.data.remote.repository

import com.vitalii.komaniak.data.remote.DataSource
import com.vitalii.komaniak.data.remote.model.StylesResponse
import com.vitalii.komaniak.domain.repository.StylesRepository

class StylesRepositoryImpl(private val stylesDataSource: DataSource<String, StylesResponse>) :
    StylesRepository {

    override suspend fun loadStyles(stylesUrl: String) {
        stylesDataSource.read(input = stylesUrl)
    }
}