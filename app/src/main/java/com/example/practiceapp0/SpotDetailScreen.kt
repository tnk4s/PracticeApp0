package com.example.practiceapp0

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.LatLng
import com.example.practiceapp0.ui.theme.PracticeApp0Theme

@Composable
fun SpotDetailScreen(navController: NavController, spotId: String?, viewModel: SpotViewModel) {
    var rating by remember { mutableStateOf(0) }  // 星1をデフォルトに設定
    println("SpotDetailScreen ViewModel instance: ${viewModel.hashCode()}")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Spot Details for: $spotId")
        Spacer(modifier = Modifier.height(16.dp))

        // 星評価
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            (1..5).forEach { star ->
                Icon(
                    imageVector = if (star <= rating) Icons.Filled.Star else Icons.Outlined.Star,
                    contentDescription = "Rating Star",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            rating = star  // 星がクリックされたら評価を設定
                        },
                    tint = if (star <= rating) Color(0xFFFFA500) else Color.Gray  // 星の色をオレンジに設定
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Your Rating: $rating stars",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            spotId?.let {
                // spotId を LatLng に変換して ViewModel に追加
                val latLng = LatLng(it.split(",")[0].toDouble(), it.split(",")[1].toDouble())
                viewModel.addRatedSpot(latLng)
                println("Added spot: $latLng")  // 追加されたスポットの座標を確認
            }
            navController.popBackStack()  // 前のページに戻る
        }) {
            Text("Register or Review")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpotDetailScreenPreview() {
    val navController = rememberNavController()
    val viewModel: SpotViewModel = viewModel()  // プレビュー用にViewModelを作成

    PracticeApp0Theme {
        SpotDetailScreen(navController, spotId = "35.6895,139.6917", viewModel = viewModel)
    }
}