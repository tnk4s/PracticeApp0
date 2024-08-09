package com.example.practiceapp0

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practiceapp0.ui.theme.PracticeApp0Theme

@Composable
fun Screen3() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "画面3")
    }
}

@Preview(showBackground = true)
@Composable
fun Screen3Preview() {
    PracticeApp0Theme {
        Screen3()
    }
}