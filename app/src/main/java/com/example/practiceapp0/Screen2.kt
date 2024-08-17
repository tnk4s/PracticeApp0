package com.example.practiceapp0

import android.media.RingtoneManager
import android.os.CountDownTimer
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import com.example.practiceapp0.ui.theme.PracticeApp0Theme

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Screen2() {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        // タブの作成
        TabRow(selectedTabIndex = pagerState.currentPage) {
            Tab(text = { Text("タイマー") }, selected = pagerState.currentPage == 0, onClick = {
                coroutineScope.launch { pagerState.animateScrollToPage(0) }
            })
            Tab(text = { Text("3-2") }, selected = pagerState.currentPage == 1, onClick = {
                coroutineScope.launch { pagerState.animateScrollToPage(1) }
            })
            Tab(text = { Text("3-3") }, selected = pagerState.currentPage == 2, onClick = {
                coroutineScope.launch { pagerState.animateScrollToPage(2) }
            })
        }

        // ページの作成
        HorizontalPager(count = 3, state = pagerState) { page ->
            when (page) {
                0 -> TimerScreen()
                1 -> TextScreen("3-2")
                2 -> TextScreen("3-3")
            }
        }
    }
}

@Composable
fun TimerScreen() {
    var timeInput by remember { mutableStateOf(TextFieldValue("5")) }
    var timeRemaining by remember { mutableStateOf(5L) }
    var isRunning by remember { mutableStateOf(false) }
    var timer: CountDownTimer? by remember { mutableStateOf(null) }

    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(
                value = timeInput,
                onValueChange = { timeInput = it },
                label = { Text("タイマー時間（秒）") },
                modifier = Modifier.padding(16.dp)
            )

            Text(
                text = "残り時間: $timeRemaining 秒",
                modifier = Modifier.padding(16.dp)
            )

            Button(
                onClick = {
                    if (!isRunning) {
                        val totalTime = timeInput.text.toLongOrNull() ?: 10L
                        timeRemaining = totalTime
                        timer = object : CountDownTimer(totalTime * 1000, 1000) {
                            override fun onTick(millisUntilFinished: Long) {
                                timeRemaining = millisUntilFinished / 1000
                            }

                            override fun onFinish() {
                                isRunning = false
                                timeRemaining = 0
                                // システムの通知音を再生
                                val notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                                val ringtone = RingtoneManager.getRingtone(context, notification)
                                ringtone.play()
                            }
                        }.start()
                        isRunning = true
                    } else {
                        timer?.cancel()
                        timeRemaining = timeInput.text.toLongOrNull() ?: 10L
                        isRunning = false
                    }
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(if (isRunning) "リセット" else "スタート")
            }
        }
    }
}

@Composable
fun TextScreen(text: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun Screen2Preview() {
    PracticeApp0Theme {
        Screen2()
    }
}