package jp.kawagh.mint

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource


@Composable
fun MainScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = MaterialTheme.typography.h3.fontSize
        )

        LazyColumn(
        ) {
            items(sampleTasks) { task ->
                TaskRow(task = task)
            }
        }
    }
}

@Composable
fun TaskRow(task: Task) {
    Text(
        text = task.name,
        fontSize = MaterialTheme.typography.h4.fontSize
    )
}
