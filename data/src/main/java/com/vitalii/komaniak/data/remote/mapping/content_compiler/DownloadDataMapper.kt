package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.domain.model.content_compiler.DownloadData
import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerDownloadData

class DownloadDataMapper : DataMapper<ContentCompilerDownloadData, DownloadData>() {
    override fun ContentCompilerDownloadData.fromDto(): DownloadData {
        return DownloadData(callback = CallbackDataMapper().convertNullable(callback),
            downloadable = downloadable,
            downloadingExpireIn = downloadingExpireIn,
            downloadingEndDate = downloadingEndDate)
    }
}
