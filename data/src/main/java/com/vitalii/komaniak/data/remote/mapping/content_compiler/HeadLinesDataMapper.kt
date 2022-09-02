package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.domain.model.content_compiler.HeadLines
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerHeadLines
import com.vitalii.komaniak.domain.model.content_compiler.Slot

class HeadLinesDataMapper : DataMapper<ContentCompilerHeadLines, HeadLines>() {

    override fun ContentCompilerHeadLines.fromDto(): HeadLines {
        return HeadLines(
            slot1 = Slot(slot1?.text, slot1?.hasTitleDivider),
            slot2 = Slot(slot2?.text, slot2?.hasTitleDivider),
            description = Slot(description?.text, slot2?.hasTitleDivider),
            badge = BadgeDataMapper().convertNullable(badge)
        )
    }
}