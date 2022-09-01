package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentCompilerMetadata(
    @SerialName("nid") val nId: Int?,
    @SerialName("videoId") val videoId: String?,
    @SerialName("url") val url: String?,
    @SerialName("pageType") val pageType: String?,
    @SerialName("episodeNumber") val episodeNumber: Int?,
    @SerialName("seasonNumber") val seasonNumber: Int?,
    @SerialName("showName") val showName: String?,
    @SerialName("title") val title: String?,
    @SerialName("contentType") val contentType: String?,
    @SerialName("elementType") val elementType: String?, // click_event:category
    @SerialName("action") val action: String?,  //click_event:action
    @SerialName("label") val label: String?,
    @SerialName("clickthroughUrl") val clickthroughUrl: String?,
    @SerialName("itemText") val itemText: String?, //click_event:item_name
    @SerialName("listMode") val listMode: String?, //list_click:category, list_interact:category
    @SerialName("listTitle") val listTitle: String?, //list_click:label, list_interact:label
    @SerialName("listPosition") val listPosition: Int?, //list_click:position, list_interact:position
    @SerialName("navigationTitle") val navigationTitle: String?, //nav_interact:label
    @SerialName("componentName") val componentName: String?, // play_click:label
    @SerialName("navComponentName") val navComponentName: String?, //nav_interact:category
    @SerialName("isPlayback") val isPlayback: Boolean?,
    @SerialName("isNavigation") val isNavigation: Boolean?,
    @SerialName("channel") val channel: String?,
    @SerialName("isLive") val isLive: Boolean?,
    @SerialName("isFullVideo") val isFullVideo: Boolean?,
    @SerialName("isRelatedToShow") val isRelatedToShow: Boolean? = null,
    @SerialName("duration") val duration: Int?,
    @SerialName("authPlaybackEnd") val authPlaybackEnd: Long?,
    @SerialName("authPlaybackStart") val authPlaybackStart: Long?,
    @SerialName("unauthPlaybackEnd") val unauthPlaybackEnd: Long?,
    @SerialName("unauthPlaybackStart") val unauthPlaybackStart: Long?,
    @SerialName("premiereDate") val premiereDate: Long?,
    @SerialName("nielsen") val nielsen: ContentCompilerNielsen?,
    @SerialName("comscore") val comscore: ContentCompilerComscore?,
    @SerialName("genre") val genres: List<String>?,
    @SerialName("isWatchlistButton") val isWatchlistButton: Boolean?,
    @SerialName("watchlistContentType") val typeOfContent: String?, //series, movies
    @SerialName("watchlistAction") val watchlistAction: String?, //add, remove, play
    @SerialName("seriesName") val seriesName: String?, //add, remove, play
    @SerialName("seriesNid") val seriesNid: Int?, //add, remove, play
)