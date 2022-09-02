package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerMetadata

class MetadataDataMapper : DataMapper<ContentCompilerMetadata, MetadataModel>() {

    override fun ContentCompilerMetadata.fromDto(): MetadataModel {
        return MetadataModel(
                nId = nId,
                videoId = videoId,
                url = url,
                pageType = pageType,
                episodeNumber = episodeNumber,
                seasonNumber = seasonNumber,
                showName = showName,
                title = title,
                contentType = contentType,
                elementType = elementType,
                action = action,
                label = label,
                clickthroughUrl = clickthroughUrl,
                itemText = itemText,
                listMode = listMode,
                listTitle = listTitle,
                listPosition = listPosition,
                navigationTitle = navigationTitle,
                componentName = componentName,
                isPlayback = isPlayback,
                isNavigation = isNavigation,
                navComponentName = navComponentName,
                isLive = isLive,
                isFullVideo = isFullVideo,
                isRelatedToShow = isRelatedToShow,
                duration = duration,
                channel = channel,
                unauthPlaybackEnd = unauthPlaybackEnd,
                unauthPlaybackStart = unauthPlaybackStart,
                authPlaybackEnd = authPlaybackEnd,
                authPlaybackStart = authPlaybackStart,
                premiereDate = premiereDate,
                nielsen = NielsenDataMapper().convertNullable(nielsen),
                comscore = ComscoreDataMapper().convertNullable(comscore),
                genres = genres,
                isWatchlistButton = isWatchlistButton,
                typeOfContent = typeOfContent,
                watchlistAction = watchlistAction,
                seriesName = seriesName,
                seriesNid = seriesNid,
        )
    }
}