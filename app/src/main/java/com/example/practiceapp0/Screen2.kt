package com.example.practiceapp0

import android.media.RingtoneManager
import android.os.CountDownTimer
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practiceapp0.ui.theme.PracticeApp0Theme

@Composable
fun Screen2() {
    var timeInput by remember { mutableStateOf(TextFieldValue("10")) }
    var timeRemaining by remember { mutableStateOf(10L) }
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

@Preview(showBackground = true)
@Composable
fun Screen2Preview() {
    PracticeApp0Theme {
        Screen2()
    }
}