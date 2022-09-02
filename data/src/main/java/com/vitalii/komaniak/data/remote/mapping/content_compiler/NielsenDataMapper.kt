package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerNielsen

class NielsenDataMapper : DataMapper<ContentCompilerNielsen, MetadataModel.Nielsen>() {
    override fun ContentCompilerNielsen.fromDto(): MetadataModel.Nielsen {
        return MetadataModel.Nielsen(
            nielsenSummaryTypeCode = nielsenSummaryTypeCode,
            adLoadType = adloadtype,
            type = type,
        )
    }
}