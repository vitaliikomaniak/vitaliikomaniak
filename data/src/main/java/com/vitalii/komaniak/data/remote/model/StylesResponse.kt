package com.vitalii.komaniak.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StylesResponse(
    @SerialName("font_styles") val fontStyles: List<FontStyleResponse>,
    @SerialName("selector_styles") val selectorStyles: Map<String, SelectorStyleResponse>,
    @SerialName("components") val components: Map<String, Map<String, String>>,
    @SerialName("screens") val screenStyles: Map<String, ScreenStyleResponse>,
    @SerialName("dimensions") val dimensions: Map<String, DimensionsResponse>?,
    @SerialName("effects") val effects: Map<String, EffectsResponse>?
)

@Serializable
data class FontStyleResponse(
    @SerialName("name") val styleName: String = DEFAULT_STYLE_NAME,
    @SerialName("lineHeight") val lineHeight: Int? = null,
    @SerialName("textTransform") val case: String = DEFAULT_TEXT_CASE,
    @SerialName("color") val fontColor: ColorResponse = DEFAULT_TEXT_COLOR,
    @SerialName("font") val font: FontResponse = DEFAULT_FONT,
    @SerialName("letterSpacing") val letterSpacing: Float = DEFAULT_LETTER_SPACING,
    @SerialName("lineSpacingMultiplier") val lineSpacingMultiplier: Float? = null,
    @SerialName("maxLines") val maxLines: Int? = null
) {

    companion object {
        //todo rework this some time
        const val DEFAULT_STYLE_NAME = "default"
        const val DEFAULT_FONT_FAMILY = "Unitext"
        const val DEFAULT_FONT_NAME = "Unitext-Light"
        const val DEFAULT_FONT_SIZE = 36f
        const val DEFAULT_FONT_WEIGHT = "200"
        const val DEFAULT_LINE_HEIGHT = 12f
        const val DEFAULT_TEXT_CASE = "normal"
        const val DEFAULT_FONT_STRETCH = "normal"
        const val DEFAULT_LETTER_SPACING = 0f
        val DEFAULT_TEXT_COLOR =
            ColorResponse(
                "#ffffff",
                255,
                255,
                255,
                1
            )
        val DEFAULT_FONT = FontResponse(
            DEFAULT_FONT_FAMILY,
            DEFAULT_FONT_NAME,
            DEFAULT_FONT_SIZE,
            DEFAULT_FONT_WEIGHT,
            DEFAULT_FONT_STRETCH
        )
    }
}

@Serializable
data class SelectorStyleResponse(
    @SerialName("normal") val normalState: StateResponse?,
    @SerialName("focused") val focusedState: StateResponse?,
    @SerialName("active") val activeState: StateResponse?,
    @SerialName("pressed") val pressedState: StateResponse?,
)

@Serializable
data class FontResponse(
    @SerialName("family") val family: String,
    @SerialName("postscriptName") val fontName: String,
    @SerialName("size") val fontSize: Float,
    @SerialName("weight") val weight: String,
    @SerialName("stretch") val stretch: String
)

@Serializable
data class ColorResponse(
    @SerialName("hex") val hex: String?,
    @SerialName("red") val red: Int,
    @SerialName("green") val green: Int,
    @SerialName("blue") val blue: Int,
    @SerialName("alpha") val alpha: Int
)

@Serializable
data class GradientResponse(
    @SerialName("start") val start: ColorResponse,
    @SerialName("center") val center: ColorResponse?,
    @SerialName("end") val end: ColorResponse,
    @SerialName("direction") val direction: String?
)

@Serializable
data class ColorizedSrcResponse(@SerialName("color") val color: ColorResponse = DEFAULT_COLOR) {
    companion object {
        val DEFAULT_COLOR =
            ColorResponse(
                "#ffffff",
                255,
                255,
                255,
                1
            )
    }
}

@Serializable
data class StateResponse(
    @SerialName("type") val type: String = DEFAULT_TYPE,
    @SerialName("text") val text: String? = null,
    @SerialName("strokeWidth") val strokeWidth: Float = DEFAULT_STROKE_WIDTH,
    @SerialName("strokeColor") val strokeColor: ColorizedSrcResponse?,
    @SerialName("layerInset") val layerInset: Float = DEFAULT_LAYER_INSET,
    @SerialName("cornerRadius") val cornerRadius: Float = DEFAULT_CORNER_RADIUS,
    @SerialName("cornerLeftTop") val cornerLeftTop: Boolean? = null,
    @SerialName("cornerRightTop") val cornerRightTop: Boolean? = null,
    @SerialName("cornerRightBottom") val cornerRightBottom: Boolean? = null,
    @SerialName("cornerLeftBottom") val cornerLeftBottom: Boolean? = null,
    @SerialName("shape") val shape: String? = null,
    @SerialName("icon") val icon: ColorizedSrcResponse? = null,
    @SerialName("background") val background: ColorizedSrcResponse? = null,
    @SerialName("gradient") val gradient: GradientResponse? = null,
    @SerialName("shadow") val shadow: ShadowResponse? = null,
) {

    companion object {
        const val DEFAULT_TYPE = "none"
        const val DEFAULT_STROKE_WIDTH: Float = 0f
        const val DEFAULT_LAYER_INSET = 0f
        const val DEFAULT_CORNER_RADIUS = 0f
    }
}

@Serializable
data class ScreenStyleResponse(
    @SerialName("background") val background: ColorResponse?,
    @SerialName("title") val title: String?,
    @SerialName("subtitle") val subtitle: String?,
    @SerialName("title_gravity") val titleGravity: String?,
    @SerialName("subtitle_gravity") val subtitleGravity: String?,
    @SerialName("subtitle_alignment") val subtitleAlignment: String?,
    @SerialName("list_dimen_title_key") val titleDimens: String?,
    @SerialName("list_extra_dimen_title_key") val titleExtraDimens: String?,
    @SerialName("screen_dimen_space_key") val screenDimens: String?,
    @SerialName("list_dimen_space_key") val listDimens: String?,
    @SerialName("list_dimen_container_key") val containerDimens: String?,
)

@Serializable
data class ShadowResponse(
    @SerialName("color") val color: ColorResponse?,
    @SerialName("horizontal_offset") val horizontalOffset: Int?,
    @SerialName("vertical_offset") val verticalOffset: Int?
)

@Serializable
data class DimensionsResponse(
    @SerialName("mobile") val mobile: SpaceResponse?,
    @SerialName("tablet") val tablet: SpaceResponse?,
    @SerialName("tablet_landscape") val tabletLandscape: SpaceResponse?,
    @SerialName("ott") val tv: SpaceResponse?,
)

@Serializable
data class SpaceResponse(
    @SerialName("start_space") val startSpace: Int,
    @SerialName("end_space") val endSpace: Int,
    @SerialName("top_space") val topSpace: Int,
    @SerialName("bottom_space") val bottomSpace: Int,
    @SerialName("vertical_space") val verticalSpace: Int,
    @SerialName("horizontal_space") val horizontalSpace: Int,
    @SerialName("iconSize") val iconSize: Int,
    @SerialName("viewWidth")val viewWidth: Int,
    @SerialName("include_edge") val includeEdge: Boolean,
    @SerialName("gravity") val gravity: String?,
    @SerialName("horizontal_stretch_mode") val horizontalStretchMode: String?,
    @SerialName("width") val width: Int,
    @SerialName("height") val height: Int,
)

@Serializable
data class EffectsResponse(
    @SerialName("fade_seasons_swimlane") val fadeSeasonsSwimlane: FadeSizeResponse?
)

@Serializable
data class FadeSizeResponse(
    @SerialName("top_size") val topSize: Int,
    @SerialName("bottom_size") val bottomSize: Int,
    @SerialName("left_size") val leftSize: Int,
    @SerialName("right_size") val rightSize: Int,
)

