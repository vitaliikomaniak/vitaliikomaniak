package com.vitalii.komaniak.domain.repository

interface ContentCompilerRepository {
    suspend fun loadManifest(contentUrl: String)
}