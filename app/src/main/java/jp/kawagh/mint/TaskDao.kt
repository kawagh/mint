package jp.kawagh.mint

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getAllTasks(): List<Task>

    @Query("DELETE FROM tasks")
    fun deleteAllTasks(): Unit

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: Task)
}