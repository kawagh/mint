package jp.kawagh.mint

import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource


@Composable
fun MainScreen() {
    val taskViewModel = TaskViewModel(LocalContext.current.applicationContext as Application)
    val tasks = taskViewModel.tasks.observeAsState(initial = listOf()).value
    Scaffold(
        content = {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    fontSize = MaterialTheme.typography.h3.fontSize
                )
                Button(onClick = { taskViewModel.clear() }) {
                    Text("reset")
                }
                LazyColumn(
                ) {
                    items(tasks) { task ->
                        TaskRow(task = task, onClickTask = { taskViewModel.deleteById(task.id) })
                    }
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { taskViewModel.insert(Task(0, "newTask")) }) {
                Icon(Icons.Default.Add, null)
            }
        }
    )
}

@Composable
fun TaskRow(task: Task, onClickTask: (Int) -> Unit) {
    Row(modifier = Modifier.clickable { onClickTask(task.id) }) {
        Text(text = task.id.toString())
        Text(
            text = task.name,
            fontSize = MaterialTheme.typography.h4.fontSize,
        )
    }
}
