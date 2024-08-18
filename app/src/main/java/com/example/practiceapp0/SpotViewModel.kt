package com.example.practiceapp0

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import com.google.android.gms.maps.model.LatLng

class SpotViewModel : ViewModel() {
    var ratedSpots = mutableStateListOf<LatLng>()
        private set

    fun addRatedSpot(spot: LatLng) {
        ratedSpots.add(spot)
        println("Current rated spots: $ratedSpots")  // 現在の評価されたスポットのリストを確認
    }
}
