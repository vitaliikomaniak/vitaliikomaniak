package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentCompilerTextFields(
    @SerialName("title") val title: ContentCompilerText?,
    @SerialName("showTitle") val showTitle: ContentCompilerText?,
    @SerialName("title_image") val titleImage: ContentCompilerImages?,
    @SerialName("subtitle") val subtitle: ContentCompilerText?,
    @SerialName("seasonEpisodeNumber") val seasonEpisodeNumber: ContentCompilerText?,
    @SerialName("episodeTitle") val episodeTitle: ContentCompilerText?,
    @SerialName("description") val description: ContentCompilerText?,
    @SerialName("videoNickname") val videoNickname: ContentCompilerText?,
    @SerialName("originalAirDate") val originalAirDate: ContentCompilerText?,
    @SerialName("airingTime") val airingTime: ContentCompilerText?,
    @SerialName("airing") val airing: ContentCompilerText?,
    @SerialName("startTime") val startTime: ContentCompilerText?,
    @SerialName("startDate") val startDate: ContentCompilerText?,
    @SerialName("endTime") val endTime: ContentCompilerText?,
    @SerialName("endDate") val endDate: ContentCompilerText?,
    @SerialName("badge") val badge: ContentCompilerBadge?,
    @SerialName("logicalCTA") val logicalCTA: ContentCompilerText?,
    @SerialName("header") val header: ContentCompilerText?,
    @SerialName("link") val link: ContentCompilerText?,
    @SerialName("qr_code") val qrCode: ContentCompilerText?,
    @SerialName("qr_code_hint") val qrCodeHint: ContentCompilerText?,
    @SerialName("flag") val flag: ContentCompilerText?,
    @SerialName("subhead") val subhead: ContentCompilerText?,
    @SerialName("tvContentRating") val tvContentRating: ContentCompilerText?,
    @SerialName("runtime") val runtime: ContentCompilerText?,
    @SerialName("availabilityMessage") val availabilityMessage: ContentCompilerText?,
    @SerialName("genre") val genre: ContentCompilerText?,
    @SerialName("subheadings") val subheadings: List<ContentCompilerBadge>?,
    @SerialName("secondary_subheadings") val secondarySubheadings: List<ContentCompilerBadge>?,
    @SerialName("top_left_badge") val topLeftBadge: ContentCompilerBadge?,
    @SerialName("bottom_left_badge") val bottomLeftBadge: ContentCompilerBadge?,
    @SerialName("bottom_right_badge") val bottomRightBadge: ContentCompilerBadge?,
    @SerialName("bottom_description") val bottomDescription: ContentCompilerText?,
    @SerialName("minimizedPlayerTitle") val minimizedPlayerTitle: ContentCompilerText?,
    @SerialName("minimizedPlayerSubtitle") val minimizedPlayerSubtitle: ContentCompilerText?,
)