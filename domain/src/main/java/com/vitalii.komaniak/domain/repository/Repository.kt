package com.vitalii.komaniak.domain.repository

interface Repository<in Input, out Out> {

    suspend fun create(input: Input)

    suspend fun read(input: Input): Out

    suspend fun update(input: Input)

    suspend fun delete(input: Input)
}