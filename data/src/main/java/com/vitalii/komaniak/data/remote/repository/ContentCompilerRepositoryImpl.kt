package com.vitalii.komaniak.data.remote.repository

import com.vitalii.komaniak.data.remote.DataSource
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.RequestParams
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerModule
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerResponse
import com.vitalii.komaniak.domain.model.content_compiler.Module
import com.vitalii.komaniak.domain.repository.AccessTokenRepository
import com.vitalii.komaniak.domain.repository.Repository

class ContentCompilerRepositoryImpl(
    private val accessTokenRepository: AccessTokenRepository,
    private val requestHeadersRepository: Repository<String, Map<String, String>>,
    private val dataMapper: DataMapper<ContentCompilerModule, Module>,
    private val contentCompilerDataSource: DataSource<RequestParams, Result<ContentCompilerResponse>>,
) : Repository<String, Module> {

    override suspend fun read(contentUrl: String): Module {
        val token = accessTokenRepository.getValidToken()
        val headers = requestHeadersRepository.read("android").toMutableMap()
        headers["Authorization"] = "Bearer $token"

        val contentResponse = contentCompilerDataSource.read(
            input = RequestParams(requestUrl = contentUrl, headers = headers)
        )
        return dataMapper.convert(contentResponse.getOrThrow().data!!)
    }
}