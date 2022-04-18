package jp.kawagh.mint

data class Task(val id: Int = 0, val name: String)

val sampleTasks: List<Task> = listOf(
    Task(name = "task1"),
    Task(name = "task2"),
    Task(name = "task3"),
)