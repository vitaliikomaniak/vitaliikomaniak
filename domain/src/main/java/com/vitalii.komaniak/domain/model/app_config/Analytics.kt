package com.vitalii.komaniak.domain.model.app_config

data class Analytics(
    val oneTrust: OneTrustAnalytics? = null,
    val youbora: YouboraAnalytics? = null,
    val comScore: ComScoreAnalytics? = null,
)

data class ComScoreAnalytics(
    val comScoreAccountId: String? = null,
)

data class YouboraAnalytics(
    val youboraAppId: String? = null,
    val youboraNetworkId: String? = null,
    val appName: String? = null,
)

data class OneTrustAnalytics(
    val oneTrustAppId: String? = null,
)