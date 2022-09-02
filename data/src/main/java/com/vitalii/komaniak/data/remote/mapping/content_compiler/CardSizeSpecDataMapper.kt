package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.domain.model.content_compiler.CardSize
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerCardSize

class CardSizeSpecDataMapper :
    DataMapper<ContentCompilerCardSize.ContentCompilerCardSizeSpec, CardSize.CardSizeSpec>() {

    override fun ContentCompilerCardSize.ContentCompilerCardSizeSpec.fromDto(): CardSize.CardSizeSpec {
        return CardSize.CardSizeSpec(
            width = cardWidth,
            height = cardHeight
        )
    }
}