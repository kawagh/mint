package jp.kawagh.mint

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import jp.kawagh.mint.ui.theme.MintTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    val taskViewModel = TaskViewModel(LocalContext.current.applicationContext as Application)
    val handleAddClick: (task: Task) -> Unit = {
        taskViewModel.insert(it)
    }
    MintTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            NavHost(navController = navController, startDestination = "main") {
                composable("main") {
                    MainScreen(taskViewModel) { navController.navigate("add") }
                }
                composable("add") {
                    AddScreen(handleAddClick) { navController.navigate("main") }
                }
            }
        }
    }
}
