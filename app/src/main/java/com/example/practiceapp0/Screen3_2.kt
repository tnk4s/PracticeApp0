package com.example.practiceapp0

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.practiceapp0.ui.theme.PracticeApp0Theme

@Composable
fun Screen3_2(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Top logo for fitness
        Image(
            painter = painterResource(id = R.drawable.mascle_log), // Replace with your main logo's resource ID
            contentDescription = "Fitness Logo",
            modifier = Modifier
                .height(100.dp)
                .padding(bottom = 32.dp)
        )

        // Button to navigate to Push-ups screen
        Button(onClick = { navController.navigate("push_ups") }) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.push), // Replace with your push-ups logo's resource ID
                    contentDescription = "Push-ups Logo",
                    modifier = Modifier.height(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Push-ups")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Button to navigate to Squats screen
        Button(onClick = { navController.navigate("squats") }) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.squat), // Replace with your squats logo's resource ID
                    contentDescription = "Squats Logo",
                    modifier = Modifier.height(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Squats")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Button to navigate to Pull-ups screen
        Button(onClick = { navController.navigate("pull_ups") }) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.pull), // Replace with your pull-ups logo's resource ID
                    contentDescription = "Pull-ups Logo",
                    modifier = Modifier.height(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Pull-ups")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen3_2Preview() {
    val navController = rememberNavController()  // プレビュー用のNavControllerを作成
    PracticeApp0Theme {
        Screen3_2(navController)
    }
}
