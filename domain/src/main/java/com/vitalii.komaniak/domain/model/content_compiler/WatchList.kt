package com.vitalii.komaniak.domain.model.content_compiler

data class WatchList(
    val accountId: String?,
    val profileId: String?,
    val serviceId: String?,
    val attributeType: String?,
    val dateCreated: Long?,
    val dateUpdated: Long?,
    val attributeData: List<AttributeData>?
) {
    data class AttributeData(
        val nid: String,
        val type: String?,
        val eventTime: Long?,
        val transcatonId: Int?
    )
}