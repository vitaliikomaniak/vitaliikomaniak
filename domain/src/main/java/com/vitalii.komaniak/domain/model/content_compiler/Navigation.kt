package com.vitalii.komaniak.domain.model.content_compiler

//import com.amcn.data.remote.model.content_compiler.Extras

data class Navigation(val microAppType: String?,
                      val nid: Int?,
                      val endpoint: String?,
                      val fullScreen: Boolean?,
                      val action : String?,
                      //TODO val extras : Extras?,
                      val isModal: Boolean? = false,
)
