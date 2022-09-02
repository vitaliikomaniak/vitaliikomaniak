package com.vitalii.komaniak.domain.model.content_compiler

class SubscriptionInfo(
    val accountId: String?,
    val profileId: Int?,
    val serviceId: String?,
    val attributeType: String?,
    val attributeData: SubscriptionAttribute?,
    val dateCreated: Long?,
    val dateUpdated: Long?
) {
    companion object {
        fun SubscriptionInfo.getSubscriptionStatus(): SubscriptionStatus =
            when (attributeData?.entitlementStatus ?: "") {
                SubscriptionStatus.ACTIVE.state -> SubscriptionStatus.ACTIVE
                SubscriptionStatus.INACTIVE.state -> SubscriptionStatus.INACTIVE
                SubscriptionStatus.PAUSED.state -> SubscriptionStatus.PAUSED
                else -> SubscriptionStatus.UNKNOWN
            }
    }
}

enum class SubscriptionStatus(val state: String) {
    ACTIVE("active"),
    INACTIVE("inactive"),
    PAUSED("paused"),
    UNKNOWN("")
}