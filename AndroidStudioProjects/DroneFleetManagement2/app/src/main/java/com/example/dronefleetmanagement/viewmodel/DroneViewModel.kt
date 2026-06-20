package com.example.dronefleetmanagement.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dronefleetmanagement.data.model.Drone
import com.example.dronefleetmanagement.data.repository.DroneRepository

class DroneViewModel : ViewModel() {

    private val repository = DroneRepository()

    private val _droneList = MutableLiveData<List<Drone>>()
    val droneList: LiveData<List<Drone>> = _droneList

    init {
        loadDrones()
    }

    private fun loadDrones() {
        _droneList.value = repository.getDrones()
    }

    fun searchDrone(query: String) {

        val filtered = repository.getDrones().filter {

            it.droneId.contains(query, true) ||
                    it.droneName.contains(query, true) ||
                    it.location.contains(query, true)
        }

        _droneList.value = filtered
    }

    fun filterByStatus(status: String) {

        if (status == "All") {
            loadDrones()
            return
        }

        _droneList.value =
            repository.getDrones().filter {
                it.status.equals(status, true)
            }
    }

    fun sortHighToLow() {
        _droneList.value =
            repository.getDrones().sortedByDescending {
                it.battery
            }
    }

    fun sortLowToHigh() {
        _droneList.value =
            repository.getDrones().sortedBy {
                it.battery
            }
    }
}