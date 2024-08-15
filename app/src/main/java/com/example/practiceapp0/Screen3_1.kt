package com.example.practiceapp0

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practiceapp0.ui.theme.PracticeApp0Theme

@Composable
fun Screen3_1() {
    // 名言のリスト
    val quotes = listOf(
        "The only limit to our realization of tomorrow is our doubts of today.",
        "Do not wait to strike till the iron is hot; but make it hot by striking.",
        "The future belongs to those who believe in the beauty of their dreams.",
        "It does not matter how slowly you go as long as you do not stop.",
        "The best way to predict the future is to create it."
    )

    // 現在の名言のインデックスを管理する
    var currentIndex by remember { mutableStateOf(0) }

    // 画面全体のレイアウト
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                // タッチされたときに次の名言へ
                currentIndex = (currentIndex + 1) % quotes.size
            },
        contentAlignment = Alignment.Center
    ) {
        // 背景画像の設定
        Image(
            painter = painterResource(id = R.drawable.bg_screen3),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // 画像をディスプレイ全体に広げる
        )

        // 名言のフェードイン表示
        Crossfade(targetState = currentIndex) { index ->
            // 影となるテキスト
            Text(
                text = quotes[index],
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.offset(2.dp, 2.dp)
            )
            // 本来のテキスト
            Text(
                text = quotes[index],
                color = Color.White,
                fontSize = 24.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen3_1Preview() {
    PracticeApp0Theme {
        Screen3_1()
    }
}
