package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.domain.model.content_compiler.CollapsingFooterProperties
import com.vitalii.komaniak.domain.model.content_compiler.CollapsingFooterStatesProperties
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.CollapsingFooter

class CollapsingFooterDataMapper : DataMapper<CollapsingFooter, CollapsingFooterProperties>() {
    override fun CollapsingFooter.fromDto(): CollapsingFooterProperties {
        val state = state?.run {
            CollapsingFooterStatesProperties(
                collapsedState = ButtonDataMapper().convertNullableMap(collapsedState),
                expandedState = ButtonDataMapper().convertNullableMap(expandedState),
            )
        }
        return CollapsingFooterProperties(
            listCollapsed ?: false,
            state
        )
    }
}