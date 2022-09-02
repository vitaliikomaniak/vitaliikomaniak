package com.vitalii.komaniak.domain.model.content_compiler

enum class ModulesList(val type: String) {
    PAGE(type = "page"),
    CTA(type = "action_hero"),
    CATEGORY_PICKER(type = "category_picker"),
    CATEGORY(type = "category"),   //item of CATEGORY_PICKER
    LIST(type = "list"),
    LIST_OF_LISTS(type = "list_of_lists"),
    CARD(type = "card"),
    TAB_BAR(type = "tab_bar"),
    DETAILS(type = "detail"),
    BUTTON(type = "button"),
    AUTH(type = "auth"),
    SEARCH(type = "search_bar"),
    UP_NEXT(type = "up_next"),
    END_CARD(type = "end_card"),
    VIDEO_PLAYER(type = "video_player"),
    ACTION(type = "action"),
    ACCOUNT(type = "account");

    override fun toString() = type
}