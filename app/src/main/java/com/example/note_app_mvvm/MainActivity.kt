package com.example.note_app_mvvm

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.note_app_mvvm.ui.theme.NoteappmvvmTheme
import kotlin.math.log

data class TodoItem(
    val title: String,
    val description: String,
    var isChecked: Boolean = false
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteappmvvmTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var titleText by remember { mutableStateOf("") }
                    var descriptionText by remember { mutableStateOf("") }
                    var todos by remember { mutableStateOf(mutableStateListOf<TodoItem>()) }

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
                            label = { Text("Description") },
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

                        Spacer(modifier = Modifier.height(24.dp))

                        HorizontalDivider(thickness = 2.dp)

                        Spacer(modifier = Modifier.height(24.dp))

                        // Display todo statistics
                        Text("Number of todos: ${todos.size}")

                        Spacer(modifier = Modifier.height(24.dp))

                        Text(
                            text = "Todos",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Todo list
                        LazyColumn {
                            items(todos) { todo ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Checkbox(
                                        checked = todo.isChecked,
                                        onCheckedChange = { checked ->
                                            Log.d("asd", checked.toString())
                                            val todoItemIndex = todos.indexOf(todo)
                                            if (todoItemIndex != -1) {
                                                todos[todoItemIndex] = todo.copy(isChecked = checked) // Trigger recomposition
                                            }
                                        }
                                    )

                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(todo.title, fontWeight = FontWeight.Bold)
                                        if (todo.description.isNotBlank()) {
                                            Text(todo.description, fontSize = 14.sp)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
