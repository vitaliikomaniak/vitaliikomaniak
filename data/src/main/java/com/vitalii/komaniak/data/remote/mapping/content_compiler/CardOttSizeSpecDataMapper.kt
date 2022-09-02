package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.domain.model.content_compiler.CardSize
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerCardSize

class CardOttSizeSpecDataMapper :
    DataMapper<ContentCompilerCardSize.ContentCompilerCardSizeSpec, CardSize.CardSizeSpec>() {

    override fun ContentCompilerCardSize.ContentCompilerCardSizeSpec.fromDto(): CardSize.CardSizeSpec {
        return CardSize.CardSizeSpec(
            width = calculateTVSize(cardWidth),
            height = calculateTVSize(cardHeight)
        )
    }

    private fun calculateTVSize(size: Int?) : Int? {
        var tvSize: Int ? = null
        size?.let {
            tvSize = size
            if (size > 0) {
                tvSize = size / 2
            }
        }
        return tvSize
    }
}