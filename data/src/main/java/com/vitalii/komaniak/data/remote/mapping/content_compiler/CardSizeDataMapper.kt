package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.domain.model.content_compiler.CardSize
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerCardSize

class CardSizeDataMapper : DataMapper<ContentCompilerCardSize, CardSize>() {

    private val mapper = CardSizeSpecDataMapper()
    private val mapperOtt = CardOttSizeSpecDataMapper()

    override fun ContentCompilerCardSize.fromDto(): CardSize {
        return CardSize(
            mobile = mapper.convertNullable(mobile),
            tabletPortrait = mapper.convertNullable(tablet?.portrait),
            tabletLandscape = mapper.convertNullable(tablet?.landscape),
            ott = mapperOtt.convertNullable(ott),
        )
    }
}