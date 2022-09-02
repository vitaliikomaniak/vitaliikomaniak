package com.vitalii.komaniak.domain.model.content_compiler


data class RecentlyWatched(
    var bcid: String,
    var duration: Long,
    var watchedPosition: Long,
    var watchedTimestamp: Long,
    var percentile: Double = 0.0,
    val idType: String = "",
    val serviceId: String = "",
    val seriesId: String = "",
    val externalID: String = "",
)