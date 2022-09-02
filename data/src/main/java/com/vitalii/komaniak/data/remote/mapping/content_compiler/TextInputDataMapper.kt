package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.domain.model.content_compiler.TextInput
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerInput

class TextInputDataMapper : DataMapper<ContentCompilerInput, TextInput>() {

    override fun ContentCompilerInput.fromDto(): TextInput {
        return TextInput(
            secure = secure,
            textFields = TextDataMapper().convertNullable(textFields)
        )
    }
}