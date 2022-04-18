package jp.kawagh.mint

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val db: AppDatabase = AppDatabase.getInstance(application)
    internal val tasks: LiveData<List<Task>> = db.taskDao().getAllTasks()

    fun insert(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            db.taskDao().insert(task)
        }
    }

    fun clear() {
        viewModelScope.launch(Dispatchers.IO) { db.taskDao().deleteAllTasks() }
    }

}