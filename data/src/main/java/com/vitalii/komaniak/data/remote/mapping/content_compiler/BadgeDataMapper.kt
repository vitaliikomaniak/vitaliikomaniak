package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerBadge
import com.vitalii.komaniak.domain.model.content_compiler.Badge

class BadgeDataMapper: DataMapper<ContentCompilerBadge, Badge>() {

    override fun ContentCompilerBadge.fromDto(): Badge {
        return Badge(
            type = type,
            title = title,
            icon = icon,
            url = url
        )
    }
}