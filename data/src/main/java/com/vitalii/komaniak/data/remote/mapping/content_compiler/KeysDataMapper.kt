package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerKeys
import com.vitalii.komaniak.domain.model.content_compiler.Keys

class KeysDataMapper : DataMapper<ContentCompilerKeys, Keys>() {

    override fun ContentCompilerKeys.fromDto(): Keys {
        return Keys(
            id = id,
            settingName = settingName,
            settingValue = settingValue,
        )
    }
}