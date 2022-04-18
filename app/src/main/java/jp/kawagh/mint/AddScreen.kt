package jp.kawagh.mint

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester

@Composable
fun AddScreen(insertTask: (Task) -> Unit, onNavigateMain: () -> Unit) {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    val focusRequester = remember {
        FocusRequester()
    }
    val onAddClick = {
        val task = Task(name = text)
        insertTask(task)
        onNavigateMain.invoke()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = text,
            label = { Text(text = "name") },
            placeholder = { Text(text = "Input a task name") },
            onValueChange = { text = it },
            modifier = Modifier.focusRequester(focusRequester)
        )
        Button(onClick = onAddClick) {
            Text("add")
        }
    }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}
