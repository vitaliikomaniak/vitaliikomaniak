package com.vitalii.komaniak.domain.model.content_compiler

data class Module(val type: String?,
                  val properties: Properties?,
                  val children: List<Module>?,
                  val endpoint: String?,
                  val callback: Callback? = null
){
    fun getModuleOrNull(type: String): Module? {
        return children?.find { it.type?.equals(type, true) ?: false }
    }
}