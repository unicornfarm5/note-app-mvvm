package com.example.note_app_mvvm.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class viewmodel {
}

class TitleCard:ViewModel () {
    var titleText by mutableStateOf("")
    var descriptionText by mutableStateOf("")
}