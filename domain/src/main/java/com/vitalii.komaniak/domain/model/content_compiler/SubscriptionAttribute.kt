package com.vitalii.komaniak.domain.model.content_compiler

class SubscriptionAttribute(val store: String?,
                            val trial: Boolean?,
                            val platform: String?,
                            val accountId: String?,
                            val autorenew: String?,
                            val ccCountry: String?,
                            val productId: String?,
                            val serviceId: String?,
                            val campaignId: String?,
                            val billingStatus: String?,
                            val trialRedeemed: Boolean?,
                            val appliedPromoCode: String?,
                            val entitlementStatus: String?,
                            val productDisplayName: String?,
                            val billingPeriodEndDate: Long?,
)