package com.vitalii.komaniak.domain.model.content_compiler

import android.os.Parcel
import android.os.Parcelable

data class MetadataModel(
    val nId: Int? = null,
    val videoId: String? = null,
    val url: String? = null,
    val pageType: String? = null,
    val episodeNumber: Int? = null,
    val seasonNumber: Int? = null,
    val showName: String? = null,
    val title: String? = null,
    val contentType: String? = null,
    val genres: List<String>? = null,
    val elementType: String? = null, // click_event:category
    val action: String? = null,  //click_event:action
    val label: String? = null,  //click_event:label
    val clickthroughUrl: String? = null,
    val itemText: String? = null, //click_event:item_name
    val listMode: String? = null, //list_click:category, list_interact:category
    val listTitle: String? = null, //list_click:label, list_interact:label
    val listPosition: Int? = null, //list_click:position, list_interact:position
    val navigationTitle: String? = null, //nav_interact:label
    val componentName: String? = null, //play_click:label
    val navComponentName: String? = null, //nav_interact:category,
    val isPlayback: Boolean? = null,
    val isNavigation: Boolean? = null,
    val channel: String? = null,
    val isLive: Boolean? = null,
    val isFullVideo: Boolean? = null,
    val isRelatedToShow: Boolean? = null,
    val duration: Int? = null,
    val authPlaybackEnd: Long? = null,
    val authPlaybackStart: Long? = null,
    val unauthPlaybackEnd: Long? = null,
    val unauthPlaybackStart: Long? = null,
    val premiereDate: Long? = null,
    val nielsen: Nielsen? = null,
    val comscore: Comscore? = null,
    val isWatchlistButton: Boolean? = null,
    val typeOfContent: String? = null, //movies, series
    val watchlistAction: String? = null, //add, remove, play
    val seriesName: String? = null,
    val seriesNid: Int? = null,
) : Parcelable {
    data class Nielsen(
        val nielsenSummaryTypeCode: String? = null,
        val adLoadType: String? = null,
        val type: String? = null,
    )

    data class Comscore(val classificationType: String? = null)

    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Long::class.java.classLoader) as? Long,
        parcel.readValue(Long::class.java.classLoader) as? Long,
        parcel.readValue(Long::class.java.classLoader) as? Long,
        parcel.readValue(Long::class.java.classLoader) as? Long,
        parcel.readValue(Long::class.java.classLoader) as? Long,
        TODO("nielsen"),
        TODO("comscore"),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int) {
    }

    constructor(child: MetadataModel?, parent: MetadataModel?) : this(
        nId = child?.nId ?: parent?.nId,
        videoId = child?.videoId ?: parent?.videoId,
        url = child?.url ?: parent?.url,
        pageType = child?.pageType ?: parent?.pageType,
        episodeNumber = child?.episodeNumber ?: parent?.episodeNumber,
        seasonNumber = child?.seasonNumber ?: parent?.seasonNumber,
        showName = child?.showName ?: parent?.showName,
        title = child?.title ?: parent?.title,
        contentType = child?.contentType ?: parent?.contentType,
        genres = child?.genres ?: parent?.genres,
        elementType = child?.elementType ?: parent?.elementType,
        action = child?.action ?: parent?.action,
        label = child?.label ?: parent?.label,
        clickthroughUrl = child?.clickthroughUrl ?: parent?.clickthroughUrl,
        itemText = child?.itemText ?: parent?.itemText,
        listMode = child?.listMode ?: parent?.listMode,
        listTitle = child?.listTitle ?: parent?.listTitle,
        listPosition = child?.listPosition ?: parent?.listPosition,
        navigationTitle = child?.navigationTitle ?: parent?.navigationTitle,
        componentName = child?.componentName ?: parent?.componentName,
        navComponentName = child?.navComponentName ?: parent?.navComponentName,
        isPlayback = child?.isPlayback ?: parent?.isPlayback,
        isNavigation = child?.isNavigation ?: parent?.isNavigation,
        channel = child?.channel ?: parent?.channel,
        isLive = child?.isLive ?: parent?.isLive,
        isFullVideo = child?.isFullVideo ?: parent?.isFullVideo,
        isRelatedToShow = child?.isRelatedToShow ?: parent?.isRelatedToShow,
        duration = child?.duration ?: parent?.duration,
        authPlaybackEnd = child?.authPlaybackEnd ?: parent?.authPlaybackEnd,
        authPlaybackStart = child?.authPlaybackStart ?: parent?.authPlaybackStart,
        unauthPlaybackEnd = child?.unauthPlaybackEnd ?: parent?.unauthPlaybackEnd,
        unauthPlaybackStart = child?.unauthPlaybackStart ?: parent?.unauthPlaybackStart,
        premiereDate = child?.premiereDate ?: parent?.premiereDate,
        nielsen = child?.nielsen ?: parent?.nielsen,
        comscore = child?.comscore ?: parent?.comscore,
        isWatchlistButton = child?.isWatchlistButton ?: parent?.isWatchlistButton,
        typeOfContent = child?.typeOfContent ?: parent?.typeOfContent,
        watchlistAction = child?.watchlistAction ?: parent?.watchlistAction,
        seriesNid = child?.seriesNid ?: parent?.seriesNid,
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(nId)
        parcel.writeString(videoId)
        parcel.writeString(url)
        parcel.writeString(pageType)
        parcel.writeValue(episodeNumber)
        parcel.writeValue(seasonNumber)
        parcel.writeString(showName)
        parcel.writeString(title)
        parcel.writeString(contentType)
        parcel.writeStringList(genres)
        parcel.writeString(elementType)
        parcel.writeString(action)
        parcel.writeString(label)
        parcel.writeString(clickthroughUrl)
        parcel.writeString(itemText)
        parcel.writeString(listMode)
        parcel.writeString(listTitle)
        parcel.writeValue(listPosition)
        parcel.writeString(navigationTitle)
        parcel.writeString(componentName)
        parcel.writeString(navComponentName)
        parcel.writeValue(isPlayback)
        parcel.writeValue(isNavigation)
        parcel.writeString(channel)
        parcel.writeValue(isLive)
        parcel.writeValue(isFullVideo)
        parcel.writeValue(isRelatedToShow)
        parcel.writeValue(duration)
        parcel.writeValue(authPlaybackEnd)
        parcel.writeValue(authPlaybackStart)
        parcel.writeValue(unauthPlaybackEnd)
        parcel.writeValue(unauthPlaybackStart)
        parcel.writeValue(premiereDate)
        parcel.writeValue(isWatchlistButton)
        parcel.writeString(typeOfContent)
        parcel.writeString(watchlistAction)
        parcel.writeString(seriesName)
        parcel.writeValue(seriesNid)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MetadataModel> {
        override fun createFromParcel(parcel: Parcel): MetadataModel {
            return MetadataModel(parcel)
        }

        override fun newArray(size: Int): Array<MetadataModel?> {
            return arrayOfNulls(size)
        }
    }
}