package jp.kawagh.mint

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String
)

val sampleTasks: List<Task> = listOf(
    Task(name = "task1"),
    Task(name = "task2"),
    Task(name = "task3"),
)
