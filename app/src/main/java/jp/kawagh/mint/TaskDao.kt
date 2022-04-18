package jp.kawagh.mint

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getAllTasks(): LiveData<List<Task>>

    @Query("DELETE FROM tasks")
    fun deleteAllTasks(): Unit

    @Query("DELETE FROM tasks WHERE id = :id")
    fun deleteById(id: Int): Unit

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: Task)
}