package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerModule
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerProperties
import com.vitalii.komaniak.domain.model.content_compiler.Module

class ModuleDataMapper(private val isTablet: Boolean) :
    DataMapper<ContentCompilerModule, Module>() {

    override fun ContentCompilerModule.fromDto(): Module {
        val callback = CallbackDataMapper().convertNullable(callback)
        return Module(
            type = type,
            properties = PropertiesDataMapper(isTablet).convertNullable(
                if (isTablet.not()) properties else ContentCompilerProperties(
                    properties,
                    tabletProperties
                )
            ),
            children = ModuleDataMapper(isTablet).convertNullableList(children?.filterNotNull()),
            endpoint = NavigationDataMapper.getEndpoint(request) ?: callback?.endpoint,
            callback = callback,
        )
    }
}




