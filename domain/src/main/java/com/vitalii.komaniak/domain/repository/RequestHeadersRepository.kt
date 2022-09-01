package com.vitalii.komaniak.domain.repository

interface RequestHeadersRepository {

    fun getRequestHeaders(): Map<String, String>
}