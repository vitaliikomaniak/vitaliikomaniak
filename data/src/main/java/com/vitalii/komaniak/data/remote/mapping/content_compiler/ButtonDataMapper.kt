package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerButton
import com.vitalii.komaniak.domain.model.content_compiler.Button

class ButtonDataMapper : DataMapper<ContentCompilerButton, Button>() {

    override fun ContentCompilerButton.fromDto(): Button {
        return Button(
            type = type,
            state = ButtonStateDataMapper().convertNullable(state),
            properties = ButtonPropertiesDataMapper().convertNullable(properties)
        )
    }
}