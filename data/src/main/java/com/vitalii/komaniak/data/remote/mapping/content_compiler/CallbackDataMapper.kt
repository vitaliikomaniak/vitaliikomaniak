package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.domain.model.content_compiler.Callback
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerCallback

class CallbackDataMapper :
    DataMapper<ContentCompilerCallback, Callback>() {

    override fun ContentCompilerCallback.fromDto(): Callback {
        return Callback(
            type = this.type,
            name = this.name,
            endpoint = this.endpoint
        )
    }

}