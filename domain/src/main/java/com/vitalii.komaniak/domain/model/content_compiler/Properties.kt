package com.vitalii.komaniak.domain.model.content_compiler

import com.vitalii.komaniak.domain.model.content_compiler.*

data class Properties(
    val pageType: String?,
    val contentType: String?,
    val nId: Int?,
    val iconKey: String?,
    val layout: String?,
    val videoCategory: String?,
    val textFields: Text?,
    val buttons: Map<String, Button>?,
    val primaryButtons: List<Button>?,
    val secondaryButtons: List<Button>?,
    val menuButtons: List<Button>?,
    val images: Images?,
    val castingImages: Images?,
    val title: String?,
    val headLines: HeadLines?,
    val parentKey: String?,
    val columns: Int?,
    val listColumns: ListColumns?,
    val mode: String?,
    val isFullScreenMode: Boolean?,
    val orientation: String?,
    val videoId: String?,
    val adConfigId: String?,
    val nextVideoNid: Int?,
    val childKey: String?,
    val navigation: Navigation?,
    val hasDivider: Boolean?,
    val overrideHeader: Boolean?,
    val request: RequestProperties?,
    val genres: List<String>?,
    val shortName: String?,
    val preferredProvider: String?,
    val filter: String?,
    var progressPercentage: Double? = 0.0,
    val isPrimary: Boolean?,
    val cardType: String?,
    //TODO val metadata: MetadataModel?,
    val callback: Callback?,
    val filterObject: Map<String, String>?,
    val topHeader: Module?,
    val inputs: List<TextInput>?,
    val cardSize: CardSize?,
    val listWidth: Int?,
    val blurredBackground: Boolean?,
    val imagePoster2x3 : ImagePosterProperties?,
    val imageWidePoster16x9 : ImagePosterProperties?,
    val column: Int?,
    val authRequired: Boolean?,
    val indicatorType: String?,
    val blurredOnScroll: Boolean?,
    val backgroundType: String?,
    val style: String?,
    val hideLogoWithTopBar: Boolean?,
    val collapsingList: Boolean?,
    val collapsingFooter: CollapsingFooterProperties?,
    val clickType: String?,
    var action: String?,
    val keys: Keys?,
    val scrollMode: String?,
    val isAutoScrollEnabled: Boolean?,
    val introStartTime: Long?,
    val introEndTime: Long?,
    val downlaodData: DownloadData?,
    val size: Long? = null,
    val enabledOffline: Boolean?,
    val showLogoInTopBar: Boolean?,
    val isProgressBarVisible: Boolean?,
    val isSuggestedTitlesOnSearchEnabled: Boolean?,
    val isDrawListSeparatorOnTop: Boolean?
)

data class RequestProperties(
    val endpoint: String?,
)

data class ButtonProperties(
    val textFields: Text?,
    val navigation: Navigation?,
    val iconKey: String?,
    //TODO val metadata: MetadataModel?,
)

data class ImagePosterProperties(
    val title: String?,
    val url: String?,
)

data class CollapsingFooterProperties(
    val listCollapsed: Boolean?,
    val states: CollapsingFooterStatesProperties?,
)

data class CollapsingFooterStatesProperties(
    val collapsedState: Map<String, Button>?,
    val expandedState: Map<String, Button>?,
)