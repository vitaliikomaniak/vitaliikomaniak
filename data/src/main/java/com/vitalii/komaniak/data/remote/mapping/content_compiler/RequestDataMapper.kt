package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.domain.model.content_compiler.RequestProperties
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerRequest

class RequestDataMapper : DataMapper<ContentCompilerRequest, RequestProperties>() {
    override fun ContentCompilerRequest.fromDto(): RequestProperties {
        return RequestProperties(
            endpoint = endpoint,
        )
    }
}