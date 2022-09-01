package com.vitalii.komaniak.domain.repository

interface Repository<in Input, out Out> {

    fun create(input: Input)

    fun read(input: Input): Out

    fun update(input: Input)

    fun delete(input: Input)
}