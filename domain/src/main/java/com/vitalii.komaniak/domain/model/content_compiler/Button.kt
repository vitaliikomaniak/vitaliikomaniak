package com.vitalii.komaniak.domain.model.content_compiler

data class Button(
    val type: String?,
    val properties: ButtonProperties?,
    val state: ButtonState?
)

class ButtonState(
    val unselected: ButtonProperties?,
    val selected: ButtonProperties?,
)