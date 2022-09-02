package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.domain.model.content_compiler.ListColumns
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerListColumns

class ListColumnsDataMapper :
    DataMapper<ContentCompilerListColumns, ListColumns>() {

    override fun ContentCompilerListColumns.fromDto(): ListColumns {
        return ListColumns(
            mobilePortrait = this.mobilePortrait,
            tabletPortrait = this.tabletPortrait,
            tabletLandscape = this.tabletLandscape,
            ott = this.ott
        )
    }
}