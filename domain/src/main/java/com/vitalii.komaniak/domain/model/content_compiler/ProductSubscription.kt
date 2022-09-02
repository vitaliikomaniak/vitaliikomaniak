package com.vitalii.komaniak.domain.model.content_compiler

import java.util.*

class ProductSubscription(
    val productID: String?,
    val storeProductID: String?,
    val productDisplayName: String?,
    val storeProductName: String?,
    val description: String?,
    val currency: String?,
    val price: Double?,
    val monthlyPrice: Double?,
    val annualPrice: Double?,
    val billingFrequencyDays: Long?,
    val trialDays: Long?,
    val supportsPromotions: Boolean?,
    val status: String?,
    val isTest: Boolean?,
    val autoRenew: Boolean?,
    val requiredPromoPrefix: Any?,
    val createdDate: Date?,
    val updatedDate: Date?,
    val defaultPromo: Promo?,
    val presentation: Presentation?
)

class Promo(
    val type: String,
    val defCode: String?,
    val bannerText: String?,
    val monthlyPrice: Double?,
    val annualPrice: Double?,
    val name: String?
)

class Presentation(
    val promoBanner: String?,
    val slot1: String?,
    val slot2: String?,
    val slot3: String?,
)