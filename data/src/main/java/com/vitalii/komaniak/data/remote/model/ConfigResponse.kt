package com.vitalii.komaniak.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppConfigResponse(
    @SerialName("config") val config: ConfigResponse
)

@Serializable
data class ConfigResponse(
    @SerialName("applicationType") val applicationType: String? = "",
    @SerialName("network") val network: String?,
    @SerialName("logo") val logo: String?,
    @SerialName("channel") val channel: ChannelResponse,
    @SerialName("analytics") val analytics: AnalyticsResponse?,
    @SerialName("omidPartner") val omidPartnerName: String?,
    @SerialName("background") val background: String? = "",
    @SerialName("hardcoded_endpoints") val endpoints: EndpointsResponse,
    @SerialName("ccpaCustomGroupId") val ccpaCustomGroupId: String?,
    @SerialName("ccpaJsURL") val ccpaJsURL: String?,
    @SerialName("contentCDN") val contentCDN: String? = "",
    @SerialName("continueWatchingAllowedTypes") val continueWatchingAllowedTypes: Set<String>?,
    @SerialName("useLocalStorageForBookmarks") val allowToUseLocalStorageForBookmarks: Boolean,
    @SerialName("support_service_email") val supportServiceEmail: String?,
    @SerialName("support_service") val supportService: String?,
    @SerialName("terms") val terms: String?,
    @SerialName("privacy") val privacy: String?,
    @SerialName("cookie") val cookie: String?,
    @SerialName("entry_point") val entryPoint: EntryPointResponse,
    @SerialName("unauth_entry_point") val unAuthEntryPoint: EntryPointResponse?,
    @SerialName("upsell_point") val upsellEntryPoint: EntryPointResponse?,
    @SerialName("login_point") val loginEntryPoint: EntryPointResponse?,
    @SerialName("subscription_point") val selectSubEntryPoint: EntryPointResponse?,
    @SerialName("isAPSAllowed") val allowAps: Boolean = false,
    @SerialName("watchNextAssetDaley") val watchUpNextAssetDelay: Int,
    @SerialName("upNextScheduleTimeInterval") val upNextScheduleTimeInterval: Int,
    @SerialName("keys") val keys: KeysResponse?,
    @SerialName("bookmarksHeader") val bookmarksHeader: BookmarksHeaderResponse?,
    @SerialName("bookmarksReadInterval") val bookmarksReadInterval: Int,
    @SerialName("bookmarksUpdateInterval") val bookmarksUpdateInterval: Int,
    @SerialName("bookmarksInitialSaveThreshold") val bookmarksInitialSaveThreshold: Int?,
    @SerialName("watchlistReadInterval") val watchlistReadInterval: Int?,
    @SerialName("maxStoredContinueWatching") val maxStoredContinueWatching: Int?,
    @SerialName("maxShownContinueWatching") val maxShownContinueWatching: Int?,
    @SerialName("minAcceptableAppVersionAndroid") val minAcceptableAppVersionAndroid: Int?,
    @SerialName("resetPassword") val resetPasswordUrl: String?,
    @SerialName("available_countries") val availableCountries: List<String>?,
)

@Serializable
data class BookmarksHeaderResponse(@SerialName("X-Api-Key") val apiKey: String?)

@Serializable
data class KeysResponse(
    @SerialName("chromecastReceiverAppId") val chromeCastReceiverAppId: String?,
    @SerialName("bcAccountId") val bcAccountId: String?,
    @SerialName("bcPlayerId") val bcPlayerId: String?,
)

@Serializable
data class EntryPointResponse(@SerialName("navigation") val navigation: NavigationResponse)

@Serializable
data class PlaceholdersResponse(
    @SerialName("poster") val poster: String?,
    @SerialName("square") val square: String?,
    @SerialName("wide") val wide: String?,
    @SerialName("ultrawide") val ultraWide: String?
)

@Serializable
data class NavigationResponse(
    @SerialName("micro_app_type") val microAppType: String?,
    @SerialName("request") val request: RequestResponse
)

@Serializable
data class RequestResponse(@SerialName("endpoint") val endpoint: String?)

@Serializable
data class EndpointsResponse(
    @SerialName("webSiteUrl") val webSiteUrl: String?,
    @SerialName("baseUrl") val baseUrl: String?,
    @SerialName("compilerUrl") val compilerUrl: String?,
    @SerialName("mocksUrl") val mocksUrl: String?,
    @SerialName("stylingUrl") val stylingUrl: String?,
    @SerialName("bookmarksBaseUrl") val bookmarksUrl: String?,
    @SerialName("bookmarksAddBaseUrl") val bookmarksAddBaseUrl: String?,
    @SerialName("jwtAuthBaseUrl") val authUrl: String?,
    @SerialName("myStuff") val myStuffUrl: String?,
    @SerialName("messagesUrl") val messagesUrl: String?,
    @SerialName("manifest") val manifestUrl: String?,
    @SerialName("user-manifest") val userManifestUrl: String,
    @SerialName("geolocationUrl") val geolocationUrl: String?,
    @SerialName("accountIdUrl") val accountIdUrl: String?,
)

@Serializable
data class NetworkBrandingResponse(
    @SerialName("logo") val logo: String?,
    @SerialName("placeholders") val placeholders: PlaceholdersResponse,
)

@Serializable
data class ChannelResponse(
    @SerialName("networkFullname") val fullName: String?,
    @SerialName("networkAlias") val alias: String?,
    @SerialName("serviceId") val serviceID: String?,
    @SerialName("serviceGroupId") val serviceGroupID: String?,
    @SerialName("networkBranding") val networkBranding: NetworkBrandingResponse?,
)

@Serializable
data class OneTrustResponse(
    @SerialName("oneTrustAppId") val oneTrustAppId: String?,
)

@Serializable
data class YouboraResponse(
    @SerialName("youboraAppId") val youboraAppId: String?,
    @SerialName("youboraNetworkId") val youboraNetworkId: String?
)

@Serializable
data class ComScoreResponse(
    @SerialName("comScoreAccountId") val comScoreAccountId: String?,
)

@Serializable
data class AnalyticsResponse(
    @SerialName("oneTrust") val oneTrust: OneTrustResponse?,
    @SerialName("youbora") val youbora: YouboraResponse?,
    @SerialName("comScore") val comScore: ComScoreResponse?,
)