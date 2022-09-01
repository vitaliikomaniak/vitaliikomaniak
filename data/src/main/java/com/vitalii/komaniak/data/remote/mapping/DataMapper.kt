package com.vitalii.komaniak.data.remote.mapping

abstract class DataMapper<in T, out U> {

    abstract fun T.fromDto(): U

    fun convert(dtoEntity: T): U {
        return dtoEntity.fromDto()
    }

    fun convertNullable(dtoEntity: T?): U? {
        return dtoEntity?.fromDto()
    }

    fun convertList(dtoEntityList: List<T>): List<U> {
        return dtoEntityList.map { it.fromDto() }
    }
}