package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.domain.model.content_compiler.ImagePosterProperties
import com.vitalii.komaniak.domain.model.content_compiler.Properties
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerProperties

class PropertiesDataMapper(
    private val isTablet: Boolean
) : DataMapper<ContentCompilerProperties, Properties>() {

    override fun ContentCompilerProperties.fromDto(): Properties {
        return Properties(
            pageType = pageType,
            contentType = contentType,
            nId = nId,
            iconKey = iconKey,
            layout = layout,
            videoCategory = videoCategory,
            textFields = TextDataMapper().convertNullable(textFields),
            buttons = ButtonDataMapper().convertNullableMap(buttons),
            primaryButtons = ButtonDataMapper().convertNullableList(primaryButtons),
            secondaryButtons = ButtonDataMapper().convertNullableList(secondaryButtons),
            menuButtons = ButtonDataMapper().convertNullableList(menuButtons),
            images = ImagesDataMapper().convertNullable(images),
            castingImages = ImagesDataMapper().convertNullable(castingImages),
            navigation = NavigationDataMapper().convertNullable(navigation),
            title = title,
            headLines = HeadLinesDataMapper().convertNullable(headLines),
            parentKey = parentKey,
            columns = columns,
            listColumns = ListColumnsDataMapper().convertNullable(listColumns),
            mode = mode,
            orientation = orientation,
            videoId = videoId,
            adConfigId = adConfigId,
            nextVideoNid = nextVideoNid,
            childKey = childKey,
            overrideHeader = overrideHeader,
            hasDivider = hasDivider,
            request = RequestDataMapper().convertNullable(request),
            genres = genres,
            shortName = shortname,
            preferredProvider = preferredProvider,
            filter = filter,
            isPrimary = isPrimary,
            cardType = cardType,
           //TODO metadata = MetadataDataMapper().convertNullable(metadata)
             //   .let { it?.copy(genres = metadata?.genres ?: genres) },
            callback = CallbackDataMapper().convertNullable(callback),
            filterObject = filterObject,
            topHeader = ModuleDataMapper(isTablet).convertNullable(topHeader),
            inputs = TextInputDataMapper().convertNullableList(inputs),
            cardSize = CardSizeDataMapper().convertNullable(cardSize),
            isFullScreenMode = isFullScreenMode,
            listWidth = listWidth,
            blurredBackground = blurredBackground,
            imagePoster2x3 = ImagePosterProperties(
                imagePoster2x3?.title,
                imagePoster2x3?.url
            ),
            imageWidePoster16x9 = ImagePosterProperties(
                imageWidePoster16x9?.title,
                imageWidePoster16x9?.url
            ),
            column = column,
            authRequired = authRequired,
            indicatorType = indicatorType,
            clickType = clickType,
            action = action?.action,
            keys = KeysDataMapper().convertNullable(keys),
            scrollMode = scrollMode,
            isAutoScrollEnabled = isAutoScrollEnabled,
            introStartTime = introStartTime,
            introEndTime = introEndTime,
            downlaodData = DownloadDataMapper().convertNullable(downloadData),
            enabledOffline = enabledOffline,
            blurredOnScroll = blurredOnScroll,
            backgroundType = backgroundType,
            style = style,
            hideLogoWithTopBar = hideLogoWithTopBar,
            collapsingList = collapsingList,
            collapsingFooter = CollapsingFooterDataMapper().convertNullable(collapsingFooter),
            showLogoInTopBar = showLogoInTopBar,
            isProgressBarVisible = isProgressBarVisible,
            isSuggestedTitlesOnSearchEnabled = isSuggestedTitlesOnSearchEnabled,
            isDrawListSeparatorOnTop = isDrawListSeparatorOnTop
        )
    }
}
