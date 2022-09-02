package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerButtonProperties
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerButtonState
import com.vitalii.komaniak.domain.model.content_compiler.ButtonProperties
import com.vitalii.komaniak.domain.model.content_compiler.ButtonState

class ButtonPropertiesDataMapper : DataMapper<ContentCompilerButtonProperties, ButtonProperties>() {

    override fun ContentCompilerButtonProperties.fromDto(): ButtonProperties {
        return ButtonProperties(
            textFields = TextDataMapper().convertNullable(textFields),
            navigation = NavigationDataMapper().convertNullable(navigation),
            iconKey = iconKey,
            //TODO metadata = MetadataDataMapper().convertNullable(metadata)
        )
    }
}

class ButtonStateDataMapper : DataMapper<ContentCompilerButtonState, ButtonState>() {

    override fun ContentCompilerButtonState.fromDto(): ButtonState {

        val unselectedState = ButtonProperties(
            textFields = TextDataMapper().convertNullable(unselected?.textFields),
            navigation = NavigationDataMapper().convertNullable(unselected?.navigation),
            iconKey = unselected?.iconKey,
            //TODO metadata = MetadataDataMapper().convertNullable(unselected?.metadata)
        )

        val selectedState = ButtonProperties(
            textFields = TextDataMapper().convertNullable(selected?.textFields),
            navigation = NavigationDataMapper().convertNullable(selected?.navigation),
            iconKey = selected?.iconKey,
            //TODO metadata = MetadataDataMapper().convertNullable(selected?.metadata)
        )

        return ButtonState(
            unselected = if (isNullObject(unselectedState)) null else unselectedState,
            selected = if (isNullObject(selectedState)) null else selectedState,
        )
    }

    private fun isNullObject(buttonProperties: ButtonProperties): Boolean {
        return buttonProperties.iconKey == null && buttonProperties.navigation == null && buttonProperties.textFields == null
    }
}