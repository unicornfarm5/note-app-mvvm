package com.example.note_app_mvvm.model

data class TodoItem(
    val title: String,
    val description: String,
    var isChecked: Boolean = false
)