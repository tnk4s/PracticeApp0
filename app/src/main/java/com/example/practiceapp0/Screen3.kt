package com.example.practiceapp0

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.practiceapp0.ui.theme.PracticeApp0Theme
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Screen3(navController: NavHostController, viewModel: SpotViewModel) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "画面3")

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController.navigate("screen3_1") }) {
                Text("Screen 3-1 へ")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController.navigate("screen3_2") }) {
                Text("Screen 3-2 へ")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen3Preview() {
    PracticeApp0Theme {
        val navController = rememberNavController()  // Preview 用の navController
        val viewModel: SpotViewModel = viewModel()  // プレビュー用のViewModelを作成
        Screen3(navController, viewModel)
    }
}
