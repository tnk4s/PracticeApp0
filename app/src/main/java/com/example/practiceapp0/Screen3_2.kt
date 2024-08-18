package com.example.practiceapp0

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.practiceapp0.ui.theme.PracticeApp0Theme
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.android.gms.maps.model.CameraPosition // 修正: CameraPosition のインポート

@Composable
fun Screen3_2(navController: NavHostController) {
    val initialLocation = LatLng(35.6895, 139.6917)  // 東京の座標

    // CameraPositionState の設定
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(initialLocation, 10f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        onMapClick = { latLng ->
            // 地図上をクリックしたときにスポットの詳細画面に遷移
            navController.navigate("spotDetail/${latLng.latitude},${latLng.longitude}")
        }
    ) {
        // Marker の状態を記憶する
        Marker(
            position = initialLocation,  // 修正: position パラメータに直接位置を指定
            title = "東京の涼スポット",
            snippet = "これはリラックスするのに良い場所です"
        )
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
