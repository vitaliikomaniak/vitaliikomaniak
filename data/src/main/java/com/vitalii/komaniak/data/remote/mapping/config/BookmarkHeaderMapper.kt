package com.vitalii.komaniak.data.remote.mapping.config

import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.BookmarksHeaderResponse
import com.vitalii.komaniak.domain.model.app_config.BookmarksHeader

class BookmarkHeaderMapper : DataMapper<BookmarksHeaderResponse, BookmarksHeader>() {

    override fun BookmarksHeaderResponse.fromDto(): BookmarksHeader {
        return BookmarksHeader(
            apiKey = this.apiKey ?: ""
        )
    }
}