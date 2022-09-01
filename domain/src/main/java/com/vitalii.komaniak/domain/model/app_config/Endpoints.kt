package com.vitalii.komaniak.domain.model.app_config

data class Endpoints(
    val webSite: String? = "https://url.com/",
    val baseUrl: String? = "https://test.base-url.com/",
    val compilerUrl: String? = "https://test.compiler-url.com/",
    val mocksUrl: String? = "https://test.mocks-url.com/",
    val bookmarkServiceUrl: String? = "https://test.bookmark-service-url.com/",
    val bookmarkAddUrl: String? = "https://test.watch-gw.cds.amcn.com/",
    val stylingUrl: String? = "https://test.styling-url.com/",
    val authBaseUrl: String? = "https://test.auth-url.com/",
    val mvpdUrl: String? = "https://test.mvpd-url.com/",
    val searchUrl: String? = "http://test.search-url.com/",
    val myStuffUrl: String? = "http://localhost/",
    val messagesUrl: String? = "https://test.messages-url.com/",
    val manifestUrl: String? = "https://test.manifest.com/",
    val userManifestUrl: String? = "https://test.user-manifest.com/",
    val geolocationUrl: String? = "https://test.geolocation-url.com/",
    val videoPlayerId: String? = "/test/video-player/id",
    val accountIdUrl: String? = "https://test/account-id/api/v1",
    val catalogUrl: String? = null,
)