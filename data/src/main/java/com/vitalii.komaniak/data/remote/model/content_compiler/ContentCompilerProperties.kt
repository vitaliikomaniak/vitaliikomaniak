package com.vitalii.komaniak.data.remote.model.content_compiler

import com.google.gson.annotations.SerializedName
import com.vitalii.komaniak.data.remote.model.content_compiler.*

data class ContentCompilerProperties(
    @SerializedName("pageType") val pageType: String?,
    @SerializedName("contentType") val contentType: String?,
    @SerializedName("nid") val nId: Int?,
    @SerializedName("layout") val layout: String?,
    @SerializedName("iconKey")  val iconKey: String?,
    @SerializedName("text") val textFields: ContentCompilerTextFields?,
    @SerializedName("buttons") val buttons: Map<String, ContentCompilerButton>?,
    @SerializedName("primaryButtons") val primaryButtons: List<ContentCompilerButton>?,
    @SerializedName("secondaryButtons") val secondaryButtons: List<ContentCompilerButton>?,
    @SerializedName("menuButtons") val menuButtons: List<ContentCompilerButton>?,
    @SerializedName("images") val images: ContentCompilerImages?,
    @SerializedName("chromecast_poster") val castingImages: ContentCompilerImages?,
    @SerializedName("title") val title: String?,
    @SerializedName("columns") val columns: Int?,
    @SerializedName("columns_number") val listColumns: ContentCompilerListColumns?,
    @SerializedName("headLines") val headLines: ContentCompilerHeadLines?,
    @SerializedName("mode") val mode: String?,
    @SerializedName("orientation") val orientation: String?,
    @SerializedName("parentKey") val parentKey: String?,
    @SerializedName("videoCategory") val videoCategory: String?,
    @SerializedName("videoId") val videoId: String?,
    @SerializedName("adConfigId") val adConfigId: String?,
    @SerializedName("nextVideoNid") val nextVideoNid: Int?,
    @SerializedName("childKey") val childKey: String?,
    @SerializedName("navigation") val navigation: ContentCompilerNavigation?,
    @SerializedName("overrideHeader") val overrideHeader: Boolean?,
    @SerializedName("hasDivider") val hasDivider: Boolean?,
    @SerializedName("request") val request: ContentCompilerRequest?,
    @SerializedName("genre") val genres: List<String>?,
    @SerializedName("shortname") val shortname: String?,
    @SerializedName("preferred_provider") val preferredProvider: String?,
    @SerializedName("filter") val filter: String?,
    @SerializedName("is_primary") val isPrimary: Boolean?,
    @SerializedName("cardType") val cardType: String?,
    @SerializedName(value = "metadata", alternate = ["meta"]) val metadata: ContentCompilerMetadata?,
    @SerializedName("callback") val callback: ContentCompilerCallback?,
    @SerializedName("filterObject") val filterObject: Map<String, String>?,
    @SerializedName("topHeader") val topHeader: ContentCompilerModule?,
    @SerializedName("inputs") val inputs: List<ContentCompilerInput>?,
    @SerializedName("cardSize") val cardSize: ContentCompilerCardSize?,
    @SerializedName("isFullScreenMode") val isFullScreenMode: Boolean?,
    @SerializedName("blurred_background") val blurredBackground: Boolean?,
    @SerializedName("listWidth") val listWidth: Int?,
    @SerializedName("extras") val extras : Extras?,
    @SerializedName("img_poster_2x3") val imagePoster2x3 : ImagePoster?,
    @SerializedName("img_wide_poster_16x9") val imageWidePoster16x9 : ImagePoster?,
    @SerializedName("column") val column : Int?,
    @SerializedName("authRequired") val authRequired: Boolean?,
    @SerializedName("indicatorType") val indicatorType: String?,
    @SerializedName("click_type") val clickType: String?,
    @SerializedName("action") val action: ContentCompilerAction?,
    @SerializedName("keys") val keys: ContentCompilerKeys?,
    @SerializedName("scrollMode") val scrollMode: String?,
    @SerializedName("isAutoScrollEnabled") val isAutoScrollEnabled: Boolean?,
    @SerializedName("intro_start_time") val introStartTime: Long?,
    @SerializedName("intro_end_time") val introEndTime: Long?,
    @SerializedName("downloadData") val downloadData: ContentCompilerDownloadData?,
    @SerializedName("enabledOffline") val enabledOffline: Boolean?,
    @SerializedName("blurredOnScroll") val blurredOnScroll: Boolean?,
    @SerializedName("background") val backgroundType: String?,
    @SerializedName("style") val style: String?,
    @SerializedName("hideLogoWithTopBar") val hideLogoWithTopBar: Boolean?,
    @SerializedName("collapsingList") val collapsingList: Boolean?,
    @SerializedName("collapsingFooter") val collapsingFooter: CollapsingFooter?,
    @SerializedName("showLogoInTopBar") val showLogoInTopBar: Boolean?,
    @SerializedName("isProgressBarVisible") val isProgressBarVisible: Boolean?,
    @SerializedName("isSuggestedTitlesOnSearchEnabled") val isSuggestedTitlesOnSearchEnabled: Boolean?,
    @SerializedName("isDrawListSeparatorOnTop") val isDrawListSeparatorOnTop: Boolean?,
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

data class ContentCompilerButtonProperties(
    @SerializedName("text") val textFields: ContentCompilerTextFields?,
    @SerializedName("navigation") val navigation: ContentCompilerNavigation?,
    @SerializedName("iconKey") val iconKey: String?,
    @SerializedName("metadata") val metadata: ContentCompilerMetadata?,
)

data class ContentCompilerButtonState(
    @SerializedName("unselected") val unselected: ContentCompilerButtonProperties?,
    @SerializedName("selected") val selected: ContentCompilerButtonProperties?,
)

data class Extras (
        @SerializedName("primary_tab_index") val primaryTabIndex: String,
        @SerializedName("secondary_tab_index") val secondaryTabIndex: String,
)

data class ImagePoster (
        @SerializedName("title") val title: String?,
        @SerializedName("url") val url: String?,
)

data class CollapsingFooter(
    @SerializedName("listCollapsed") val listCollapsed: Boolean?,
    @SerializedName("state") val state: CollapsingFooterStates?,
)

data class CollapsingFooterStates(
    @SerializedName("collapsed") val collapsedState: Map<String, ContentCompilerButton>?,
    @SerializedName("expanded") val expandedState: Map<String, ContentCompilerButton>?,
)
