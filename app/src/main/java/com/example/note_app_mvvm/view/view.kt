package com.example.note_app_mvvm.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.note_app_mvvm.viewmodel.TitleCard

@Composable
fun TitleCard (TitleCard: TitleCard) {
    Column(modifier = Modifier.padding(12.dp)) {
        Text(text = "Todo app", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(24.dp))

        // Title input
        TextField(
            value = titleText,
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { titleText = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Description input
        TextField(
            value = descriptionText,
            label = { Text(viewModel.titletext) },
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { descriptionText = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Add Todo Button
        Button(onClick = {
            if (titleText.isNotBlank()) {
                todos.add(TodoItem(titleText, descriptionText))
                titleText = ""
                descriptionText = ""
            }
        }) {
            Text("Add todo")
        }
}