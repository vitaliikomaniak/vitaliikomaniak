package com.vitalii.komaniak.data.remote

interface ContentCompilerDataSource {
    suspend fun loadManifest(contentManifestUrl: String)
}