package com.vitalii.komaniak.data.remote.mappers.config

import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.AppConfigResponse
import com.vitalii.komaniak.domain.model.app_config.AppConfig

class AppConfigDataMapper : DataMapper<AppConfigResponse, AppConfig>() {

    override fun AppConfigResponse.fromDto(): AppConfig {

        return AppConfig(
            applicationType = this.config.applicationType,
            omidPartnerName = this.config.omidPartnerName,
            channel = ChannelDataMapper().convertNullable(this.config.channel),
            analytics = AnalyticsDataMapper().convertNullable(this.config.analytics),
            background = this.config.background,
            ccpaJsURL = this.config.ccpaJsURL,
            ccpaCustomGroupId = this.config.ccpaCustomGroupId,
            contentCDN = this.config.contentCDN,
            continueWatchingAllowedTypes = this.config.continueWatchingAllowedTypes,
            allowToUseLocalStorageForBookmarks = this.config.allowToUseLocalStorageForBookmarks,
            supportServiceEmail = this.config.supportServiceEmail,
            supportService = this.config.supportService,
            terms = this.config.terms,
            privacy = this.config.privacy,
            cookie = this.config.cookie,
            endpoints = EndpointsDataMapper().convert(this.config.endpoints),
            entryPoint = EntryPointDataMapper().convert(this.config.entryPoint),
            unAuthEntryPoint = EntryPointDataMapper().convertNullable(this.config.unAuthEntryPoint),
            upsellEndPoint = EntryPointDataMapper().convertNullable(this.config.upsellEntryPoint),
            loginEntryPoint = EntryPointDataMapper().convertNullable(this.config.loginEntryPoint),
            allowAps = this.config.allowAps,
            watchUpNextAssetDelay = this.config.watchUpNextAssetDelay,
            upNextScheduleTimeInterval = this.config.upNextScheduleTimeInterval,
            keys = KeysDataMapper().convertNullable(this.config.keys),
            isLoaded = true,
            bookmarksHeader = this.config.bookmarksHeader?.let {
                BookmarkHeaderMapper().convertNullable(it)
            },
            bookmarksReadInterval = this.config.bookmarksReadInterval,
            bookmarksUpdateInterval = this.config.bookmarksUpdateInterval,
            bookmarksInitialSaveThreshold = this.config.bookmarksInitialSaveThreshold,
            watchlistReadInterval = this.config.watchlistReadInterval,
            maxStoredContinueWatching = this.config.maxStoredContinueWatching,
            maxShownContinueWatching = this.config.maxShownContinueWatching,
            minAcceptableAppVersionAndroid = this.config.minAcceptableAppVersionAndroid,
            resetPasswordUrl = this.config.resetPasswordUrl,
            availableCountries = this.config.availableCountries ?: emptyList()
        )
    }
}