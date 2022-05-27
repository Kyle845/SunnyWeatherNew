package com.example.sunnyweathernew.logic.network

import androidx.lifecycle.liveData
import com.example.sunnyweathernew.logic.model.Place
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import kotlin.RuntimeException

object Repository {
  fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
    val result = try {
      val placeResponse = SunnyWeatherNetWork.searchPlaces(query)
      if (placeResponse.status == "ok") {
        val places = placeResponse.places
        Result.success(places)
      } else {
        Result.failure(RuntimeException("response status is ${placeResponse.status}"))
      }
    } catch (e:Exception) {
      Result.failure<List<Place>>(e)
    }
    emit(result)
  }
}