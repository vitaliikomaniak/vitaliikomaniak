package com.vitalii.komaniak.data.remote.repository

import com.vitalii.komaniak.data.remote.ContentCompilerDataSource
import com.vitalii.komaniak.domain.repository.AccessTokenRepository
import com.vitalii.komaniak.domain.repository.ContentCompilerRepository

class ContentCompilerRepositoryImpl(private val accessTokenRepository: AccessTokenRepository,
                                    private val contentCompilerDataSource: ContentCompilerDataSource
): ContentCompilerRepository {

    override suspend fun loadManifest(contentUrl: String) {
        accessTokenRepository.validateToken {
            contentCompilerDataSource.loadManifest(contentManifestUrl = contentUrl)
        }
    }
}