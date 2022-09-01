package com.vitalii.komaniak.data.remote.model.content_compiler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentCompilerProperties(
    @SerialName("pageType") val pageType: String?,
    @SerialName("contentType") val contentType: String?,
    @SerialName("nid") val nId: Int?,
    @SerialName("layout") val layout: String?,
    @SerialName("iconKey")  val iconKey: String?,
    @SerialName("text") val textFields: ContentCompilerTextFields?,
    @SerialName("buttons") val buttons: Map<String, ContentCompilerButton>?,
    @SerialName("primaryButtons") val primaryButtons: List<ContentCompilerButton>?,
    @SerialName("secondaryButtons") val secondaryButtons: List<ContentCompilerButton>?,
    @SerialName("menuButtons") val menuButtons: List<ContentCompilerButton>?,
    @SerialName("images") val images: ContentCompilerImages?,
    @SerialName("chromecast_poster") val castingImages: ContentCompilerImages?,
    @SerialName("title") val title: String?,
    @SerialName("columns") val columns: Int?,
    @SerialName("columns_number") val listColumns: ContentCompilerListColumns?,
    @SerialName("headLines") val headLines: ContentCompilerHeadLines?,
    @SerialName("mode") val mode: String?,
    @SerialName("orientation") val orientation: String?,
    @SerialName("parentKey") val parentKey: String?,
    @SerialName("videoCategory") val videoCategory: String?,
    @SerialName("videoId") val videoId: String?,
    @SerialName("adConfigId") val adConfigId: String?,
    @SerialName("nextVideoNid") val nextVideoNid: Int?,
    @SerialName("childKey") val childKey: String?,
    @SerialName("navigation") val navigation: ContentCompilerNavigation?,
    @SerialName("overrideHeader") val overrideHeader: Boolean?,
    @SerialName("hasDivider") val hasDivider: Boolean?,
    @SerialName("request") val request: ContentCompilerRequest?,
    @SerialName("genre") val genres: List<String>?,
    @SerialName("shortname") val shortname: String?,
    @SerialName("preferred_provider") val preferredProvider: String?,
    @SerialName("filter") val filter: String?,
    @SerialName("is_primary") val isPrimary: Boolean?,
    @SerialName("cardType") val cardType: String?,
    @SerialName(value = "metadata"
       // , alternate = ["meta"]
    ) val metadata: ContentCompilerMetadata?,
    @SerialName("callback") val callback: ContentCompilerCallback?,
    @SerialName("filterObject") val filterObject: Map<String, String>?,
    @SerialName("topHeader") val topHeader: ContentCompilerModule?,
    @SerialName("inputs") val inputs: List<ContentCompilerInput>?,
    @SerialName("cardSize") val cardSize: ContentCompilerCardSize?,
    @SerialName("isFullScreenMode") val isFullScreenMode: Boolean?,
    @SerialName("blurred_background") val blurredBackground: Boolean?,
    @SerialName("listWidth") val listWidth: Int?,
    @SerialName("extras") val extras : Extras?,
    @SerialName("img_poster_2x3") val imagePoster2x3 : ImagePoster?,
    @SerialName("img_wide_poster_16x9") val imageWidePoster16x9 : ImagePoster?,
    @SerialName("column") val column : Int?,
    @SerialName("authRequired") val authRequired: Boolean?,
    @SerialName("indicatorType") val indicatorType: String?,
    @SerialName("click_type") val clickType: String?,
    @SerialName("action") val action: ContentCompilerAction?,
    @SerialName("keys") val keys: ContentCompilerKeys?,
    @SerialName("scrollMode") val scrollMode: String?,
    @SerialName("isAutoScrollEnabled") val isAutoScrollEnabled: Boolean?,
    @SerialName("intro_start_time") val introStartTime: Long?,
    @SerialName("intro_end_time") val introEndTime: Long?,
    @SerialName("downloadData") val downloadData: ContentCompilerDownloadData?,
    @SerialName("enabledOffline") val enabledOffline: Boolean?,
    @SerialName("blurredOnScroll") val blurredOnScroll: Boolean?,
    @SerialName("background") val backgroundType: String?,
    @SerialName("style") val style: String?,
    @SerialName("hideLogoWithTopBar") val hideLogoWithTopBar: Boolean?,
    @SerialName("collapsingList") val collapsingList: Boolean?,
    @SerialName("collapsingFooter") val collapsingFooter: CollapsingFooter?,
    @SerialName("showLogoInTopBar") val showLogoInTopBar: Boolean?,
    @SerialName("isProgressBarVisible") val isProgressBarVisible: Boolean?,
    @SerialName("isSuggestedTitlesOnSearchEnabled") val isSuggestedTitlesOnSearchEnabled: Boolean?,
    @SerialName("isDrawListSeparatorOnTop") val isDrawListSeparatorOnTop: Boolean?,
) {
    constructor(
        properties: ContentCompilerProperties?,
        tabletProperties: ContentCompilerProperties?
    ) : this(
        pageType = tabletProperties?.pageType ?: properties?.pageType,
        contentType = tabletProperties?.contentType ?: properties?.contentType,
        nId = tabletProperties?.nId ?: properties?.nId,
        iconKey = tabletProperties?.iconKey ?: properties?.iconKey,
        textFields = tabletProperties?.textFields ?: properties?.textFields,
        buttons = tabletProperties?.buttons ?: properties?.buttons,
        primaryButtons = tabletProperties?.primaryButtons ?: properties?.primaryButtons,
        secondaryButtons = tabletProperties?.secondaryButtons ?: properties?.secondaryButtons,
        menuButtons = tabletProperties?.menuButtons ?: properties?.menuButtons,
        images = tabletProperties?.images ?: properties?.images,
        title = tabletProperties?.title ?: properties?.title,
        columns = tabletProperties?.columns ?: properties?.columns,
        listColumns = tabletProperties?.listColumns ?: properties?.listColumns,
        headLines = tabletProperties?.headLines ?: properties?.headLines,
        mode = tabletProperties?.mode ?: properties?.mode,
        orientation = tabletProperties?.orientation ?: properties?.orientation,
        parentKey = tabletProperties?.parentKey ?: properties?.parentKey,
        videoCategory = tabletProperties?.videoCategory ?: properties?.videoCategory,
        videoId = tabletProperties?.videoId ?: properties?.videoId,
        adConfigId = tabletProperties?.adConfigId ?: properties?.adConfigId,
        nextVideoNid = tabletProperties?.nextVideoNid ?: properties?.nextVideoNid,
        childKey = tabletProperties?.childKey ?: properties?.childKey,
        navigation = tabletProperties?.navigation ?: properties?.navigation,
        overrideHeader = tabletProperties?.overrideHeader ?: properties?.overrideHeader,
        hasDivider = tabletProperties?.hasDivider ?: properties?.hasDivider,
        request = tabletProperties?.request ?: properties?.request,
        genres = tabletProperties?.genres ?: properties?.genres,
        shortname = tabletProperties?.shortname ?: properties?.shortname,
        preferredProvider = tabletProperties?.preferredProvider ?: properties?.preferredProvider,
        filter = tabletProperties?.filter ?: properties?.filter,
        isPrimary = tabletProperties?.isPrimary ?: properties?.isPrimary,
        cardType = tabletProperties?.cardType ?: properties?.cardType,
        metadata = tabletProperties?.metadata ?: properties?.metadata,
        callback = tabletProperties?.callback ?: properties?.callback,
        filterObject = tabletProperties?.filterObject ?: properties?.filterObject,
        topHeader = tabletProperties?.topHeader ?: properties?.topHeader,
        inputs = tabletProperties?.inputs ?: properties?.inputs,
        cardSize = tabletProperties?.cardSize ?: properties?.cardSize,
        isFullScreenMode = tabletProperties?.isFullScreenMode ?: properties?.isFullScreenMode,
        blurredBackground = tabletProperties?.blurredBackground ?: properties?.blurredBackground,
        listWidth = tabletProperties?.listWidth ?: properties?.listWidth,
        extras = tabletProperties?.extras ?: properties?.extras,
        imagePoster2x3 = tabletProperties?.imagePoster2x3 ?: properties?.imagePoster2x3,
        imageWidePoster16x9 = tabletProperties?.imageWidePoster16x9
            ?: properties?.imageWidePoster16x9,
        column = tabletProperties?.column ?: properties?.column,
        authRequired = tabletProperties?.authRequired ?: properties?.authRequired,
        indicatorType = tabletProperties?.indicatorType ?: properties?.indicatorType,
        blurredOnScroll = tabletProperties?.blurredOnScroll ?: properties?.blurredOnScroll,
        backgroundType = tabletProperties?.backgroundType ?: properties?.backgroundType,
        style = tabletProperties?.style ?: properties?.style,
        layout = tabletProperties?.layout ?: properties?.layout,
        hideLogoWithTopBar = tabletProperties?.hideLogoWithTopBar ?: properties?.hideLogoWithTopBar,
        castingImages = tabletProperties?.castingImages ?: properties?.castingImages,
        collapsingFooter = tabletProperties?.collapsingFooter ?: properties?.collapsingFooter,
        collapsingList = tabletProperties?.collapsingList ?: properties?.collapsingList,
        clickType = tabletProperties?.clickType ?: properties?.clickType,
        downloadData = tabletProperties?.downloadData ?: properties?.downloadData,
        enabledOffline = tabletProperties?.enabledOffline ?: properties?.enabledOffline,
        action = tabletProperties?.action ?: properties?.action,
        keys = tabletProperties?.keys ?: properties?.keys,
        scrollMode = tabletProperties?.scrollMode ?: properties?.scrollMode,
        isAutoScrollEnabled = tabletProperties?.isAutoScrollEnabled ?: properties?.isAutoScrollEnabled,
        introStartTime = tabletProperties?.introStartTime ?: properties?.introStartTime,
        introEndTime = tabletProperties?.introEndTime ?: properties?.introEndTime,
        showLogoInTopBar = tabletProperties?.showLogoInTopBar ?: properties?.showLogoInTopBar,
        isProgressBarVisible = tabletProperties?.isProgressBarVisible ?: properties?.isProgressBarVisible,
        isSuggestedTitlesOnSearchEnabled = tabletProperties?.isSuggestedTitlesOnSearchEnabled ?: properties?.isSuggestedTitlesOnSearchEnabled,
        isDrawListSeparatorOnTop = tabletProperties?.isDrawListSeparatorOnTop ?: properties?.isDrawListSeparatorOnTop,
    )
}

@Serializable
data class ContentCompilerButtonProperties(
    @SerialName("text") val textFields: ContentCompilerTextFields?,
    @SerialName("navigation") val navigation: ContentCompilerNavigation?,
    @SerialName("iconKey") val iconKey: String?,
    @SerialName("metadata") val metadata: ContentCompilerMetadata?,
)

@Serializable
data class ContentCompilerButtonState(
    @SerialName("unselected") val unselected: ContentCompilerButtonProperties?,
    @SerialName("selected") val selected: ContentCompilerButtonProperties?,
)

@Serializable
data class Extras (
        @SerialName("primary_tab_index") val primaryTabIndex: String,
        @SerialName("secondary_tab_index") val secondaryTabIndex: String,
)

@Serializable
data class ImagePoster (
        @SerialName("title") val title: String?,
        @SerialName("url") val url: String?,
)

@Serializable
data class CollapsingFooter(
    @SerialName("listCollapsed") val listCollapsed: Boolean?,
    @SerialName("state") val state: CollapsingFooterStates?,
)

@Serializable
data class CollapsingFooterStates(
    @SerialName("collapsed") val collapsedState: Map<String, ContentCompilerButton>?,
    @SerialName("expanded") val expandedState: Map<String, ContentCompilerButton>?,
)
