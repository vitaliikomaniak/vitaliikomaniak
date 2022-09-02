package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.domain.model.content_compiler.Navigation
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerNavigation

class NavigationDataMapper :
    DataMapper<ContentCompilerNavigation, Navigation>() {

    override fun ContentCompilerNavigation.fromDto(): Navigation {
        var fullScreenAfterCheckingFullscreenMode: Boolean? = this.properties?.fullscreen
        var isModalAfterCheckingFullscreenMode: Boolean? = this.properties?.isModal

        // Added this new key for preventing broke published apps. Now we should open player in modal view
        // instead of fullscreen for having opportunity show navigation in movie-details screen when
        // we open it from player view (see ticket FE-5397)
        if (this.properties?.fullScreenMode == FULL_SCREEN_MODE_MODAL) {
            fullScreenAfterCheckingFullscreenMode = false
            isModalAfterCheckingFullscreenMode = true
        }
        return Navigation(
            microAppType = this.microAppType,
            action = this.action,
            nid = this.properties?.nid,
            endpoint = getEndpoint(this.request),
            fullScreen = fullScreenAfterCheckingFullscreenMode,
            isModal = isModalAfterCheckingFullscreenMode,
            //TODO extras = this.extras
        )
    }

    companion object {
        const val FULL_SCREEN_MODE_MODAL = "modal"
        fun getEndpoint(request: ContentCompilerNavigation.ContentCompilerNavigationRequest?): String? {
            return request?.endpoint.takeIf { it?.isNotEmpty() ?: false }
                ?: request?.android.takeIf { it?.isNotEmpty() ?: false }
                ?: request?.website.takeIf { it?.isNotEmpty() ?: false }
        }
    }

}