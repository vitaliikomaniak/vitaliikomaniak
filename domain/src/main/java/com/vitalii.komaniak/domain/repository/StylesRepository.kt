package com.vitalii.komaniak.domain.repository

interface StylesRepository {
    suspend fun loadStyles(stylesUrl: String)
}