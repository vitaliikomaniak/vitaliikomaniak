package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerComscore

class ComscoreDataMapper : DataMapper<ContentCompilerComscore, MetadataModel.Comscore>() {
    override fun ContentCompilerComscore.fromDto(): MetadataModel.Comscore {
        return MetadataModel.Comscore(classificationType = classificationType)
    }
}