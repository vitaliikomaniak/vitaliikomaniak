package com.vitalii.komaniak.domain.model.content_compiler

data class CardSize(
    val mobile: CardSizeSpec?,
    val tabletPortrait: CardSizeSpec?,
    val tabletLandscape: CardSizeSpec?,
    val ott: CardSizeSpec?
) {
    data class CardSizeSpec(
        val width: Int?,
        val height: Int?
    )
}