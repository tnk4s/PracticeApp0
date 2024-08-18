package com.example.practiceapp0

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.practiceapp0.ui.theme.PracticeApp0Theme
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.android.gms.maps.model.CameraPosition

@Composable
fun Screen3_2(navController: NavHostController, viewModel: SpotViewModel) {
    val initialLocation = LatLng(35.6895, 139.6917)  // 東京の座標
    println("Screen3_2 ViewModel instance: ${viewModel.hashCode()}")

    // CameraPositionState の設定
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(initialLocation, 12f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        onMapClick = { latLng ->
            navController.navigate("spotDetail/${latLng.latitude},${latLng.longitude}")
        }
    ) {
        // 初期ピンを立てる
        Marker(
            position = initialLocation,
            title = "東京の涼スポット",
            snippet = "これはリラックスするのに良い場所です"
        )

        // 評価されたスポットにピンを立てる
        viewModel.ratedSpots.forEach { spot ->
            println("Displaying spot: $spot")  // 表示されるスポットの座標を確認
            Marker(
                position = spot,
                title = "Rated Spot",
                snippet = "This spot was rated"
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Screen3_2Preview() {
    val navController = rememberNavController()
    val viewModel = SpotViewModel()  // Preview 用に手動で ViewModel インスタンスを作成

    PracticeApp0Theme {
        Screen3_2(navController, viewModel)
    }
}
