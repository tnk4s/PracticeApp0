package com.example.practiceapp0

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practiceapp0.ui.theme.PracticeApp0Theme

@Composable
fun SpotDetailScreen(spotId: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Spot Details for: $spotId")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* 登録、レビュー、評価を行う機能を追加 */ }) {
            Text("Register or Review")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpotDetailScreenPreview() {
    PracticeApp0Theme {
        SpotDetailScreen(spotId = "123")
    }
}
