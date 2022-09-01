package com.vitalii.komaniak.domain.repository

import kotlinx.coroutines.flow.Flow

interface PreferencesRepository {
    /**
     * Allowed types are: Int, Long, Float, Double, Boolean, String, Set<String>
     */
    fun setValue(keyName: String, value: Any?)
    suspend fun setValueSync(keyName: String, value: Any?)

    /**
     * Allowed types are: Int, Long, Float, Double, Boolean, String, Set<String>
     */
    suspend fun <T> getValue(key: String, defaultValue: T): T

    fun <T> getValueFlow(key: String, defaultValue: T): Flow<T>

    companion object {
        const val KEY_CLOSED_CAPTIONS = "closed_captions"
        const val KEY_CLOSED_CAPTIONS_LOCALE = "closed_captions_locale"
        const val KEY_CC_STATE_CHANGED_BY_USER = "cc_state_changed_by_user"
        const val KEY_NIELSEN = "nielsen"
        const val KEY_ADVERTISING = "advertising"
        const val CCPA_CONSENT = "ccpa_consent"
        const val KEY_DOWNLOADS_SETTINGS_WIFI_ONLY = "settings_wifi_only"
        const val KEY_DOWNLOADS_SETTINGS_VIDEO_QUALITY = "settings_video_quality"
        const val KEY_ONBOARDING_COMPLETED = "onboarding_completed"
    }
}