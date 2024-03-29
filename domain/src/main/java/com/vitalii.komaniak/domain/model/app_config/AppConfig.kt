package com.vitalii.komaniak.domain.model.app_config

data class AppConfig(
    var applicationType: String? = null,
    var channel: Channel? = null,
    var analytics: Analytics? = null,
    var endpoints: Endpoints = Endpoints(),
    var background: String? = null,
    var ccpaCustomGroupId: String? = null,
    var ccpaJsURL: String? = null,
    var contentCDN: String? = null,
    var continueWatchingAllowedTypes: Set<String>? = null,
    var allowToUseLocalStorageForBookmarks: Boolean = false,
    var supportServiceEmail: String? = null,
    var supportService: String? = null,
    var terms: String? = null,
    var privacy: String? = null,
    var cookie: String? = null,
    var entryPoint: EntryPoint = EntryPoint(),
    var unAuthEntryPoint: EntryPoint? = null,
    var upsellEndPoint: EntryPoint? = null,
    var loginEntryPoint: EntryPoint? = null,
    var allowAps: Boolean = false,
    var omidPartnerName: String? = null,
    var watchUpNextAssetDelay: Int? = null,
    var upNextScheduleTimeInterval: Int? = null,
    var keys: Keys? = null,
    var isLoaded: Boolean = false,
    var bookmarksHeader: BookmarksHeader? = null,
    var bookmarksReadInterval: Int? = null,
    var bookmarksUpdateInterval: Int? = null,
    var bookmarksInitialSaveThreshold: Int? = null,
    var watchlistReadInterval: Int? = null,
    var maxStoredContinueWatching: Int? = null,
    var maxShownContinueWatching: Int? = null,
    var minAcceptableAppVersionAndroid: Int? = null,
    var resetPasswordUrl: String? = null,
    var availableCountries: List<String>? = null,
)
