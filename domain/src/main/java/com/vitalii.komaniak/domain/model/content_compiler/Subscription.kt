package com.vitalii.komaniak.domain.model.content_compiler


class Subscription (
    val success: Boolean?,
    val status: Int?,
    val details: Details?
)

data class Details(
    val persona: DetailsInfo?,
    val entitlement: DetailsInfo?,
    val identityMapper: DetailsInfo?,
)

data class DetailsInfo(
    val state: String?,
    val reason: Any?,
)