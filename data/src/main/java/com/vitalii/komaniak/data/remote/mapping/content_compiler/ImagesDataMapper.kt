package com.vitalii.komaniak.data.remote.mapping.content_compiler

import com.vitalii.komaniak.data.remote.mapping.DataMapper
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerDiImages
import com.vitalii.komaniak.data.remote.model.content_compiler.ContentCompilerImages
import com.vitalii.komaniak.domain.model.content_compiler.Images

class ImagesDataMapper :
    DataMapper<ContentCompilerImages, Images>() {

    override fun ContentCompilerImages.fromDto(): Images {
        return Images(
            image = getImageForDeviceType(this),
            featured = this.featured,
            bgDark = getDiImage(this.bgDark),
            bgWhite = getDiImage(this.bgWhite),
            mode = this.mode,
        )
    }

    private fun getImageForDeviceType(compilerImages: ContentCompilerImages): String? {
        val image =  compilerImages.mobile
        return if (image.isNullOrEmpty()) compilerImages.default else image
    }

    private fun getDiImage(compilerDiImages: ContentCompilerDiImages?): String? {
        return compilerDiImages?.height120px ?: compilerDiImages?.height80px
    }
}