package com.example.sunnyweathernew.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sunnyweathernew.logic.model.Place
import com.example.sunnyweathernew.logic.network.Repository

class PlaceViewModel : ViewModel() {

  private val searchLiveData = MutableLiveData<String>()

  val placeList = ArrayList<Place>()

  val placeLiveData = Transformations.switchMap(searchLiveData) {
    query -> Repository.searchPlaces(query)
  }

  fun searchPlaces(query: String) {
    searchLiveData.value = query
  }

}