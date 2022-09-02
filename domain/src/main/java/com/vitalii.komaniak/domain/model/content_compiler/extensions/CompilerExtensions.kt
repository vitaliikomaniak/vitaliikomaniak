package com.amcn.domain.model.content_compiler.extensions

import com.vitalii.komaniak.domain.model.content_compiler.Module

inline fun <reified T> Module.getModuleOrNull(): T? {
    return children?.find { it is T } as? T
}