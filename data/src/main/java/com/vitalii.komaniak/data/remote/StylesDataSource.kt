package com.vitalii.komaniak.data.remote

interface StylesDataSource {
    suspend fun loadStyles(stylesUrl: String)
}