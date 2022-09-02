package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.domain.model.content_compiler.Text
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerTextFields

class TextDataMapper : DataMapper<ContentCompilerTextFields, Text>() {
    private val badgeDataMapper = BadgeDataMapper()

    override fun ContentCompilerTextFields.fromDto(): Text {
        return Text(
            title = this.title?.title,
            showTitle = this.showTitle?.title,
            titleImage = this.titleImage?.default,
            subtitle = this.subtitle?.title,
            seasonEpisodeNumber = this.seasonEpisodeNumber?.title,
            episodeTitle = this.episodeTitle?.title,
            description = this.description?.title,
            videoNickname = this.videoNickname?.title,
            originalAirDate = this.originalAirDate?.title,
            airingTime = this.airingTime?.title,
            airing = this.airing?.title,
            startTime = this.startTime?.title,
            startDate = this.startDate?.title,
            endTime = this.endTime?.title,
            endDate = this.endDate?.title,
            badge = badgeDataMapper.convertNullable(this.badge),
            logicalCTA = this.logicalCTA?.title,
            header = this.header?.title,
            link = this.link?.title,
            qrCode = this.qrCode?.title,
            qrCodeHint = this.qrCodeHint?.title,
            flag = this.flag?.title,
            subhead = this.subhead?.title,
            tvContentRating = this.tvContentRating?.title,
            runtime = this.runtime?.title,
            availabilityMessage = this.availabilityMessage?.title,
            genre = this.genre?.title,
            subheading = badgeDataMapper.convertNullableList(this.subheadings),
            secondarySubheading = badgeDataMapper.convertNullableList(this.secondarySubheadings),
            topLeftBadge = badgeDataMapper.convertNullable(this.topLeftBadge),
            bottomLeftBadge = badgeDataMapper.convertNullable(this.bottomLeftBadge),
            bottomRightBadge = badgeDataMapper.convertNullable(this.bottomRightBadge),
            bottomDescription = this.bottomDescription?.title,
            minimizedPlayerTitle = this.minimizedPlayerTitle?.title,
            minimizedPlayerSubtitle = this.minimizedPlayerSubtitle?.title,
            )
    }
}