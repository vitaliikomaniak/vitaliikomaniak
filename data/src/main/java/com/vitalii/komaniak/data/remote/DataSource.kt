package com.vitalii.komaniak.data.remote

interface DataSource<in Input, out Out> {

    suspend fun create(input: Input) {}

    suspend fun read(input: Input): Out

    suspend fun update(input: Input) {}

    suspend fun delete(input: Input) {}
}