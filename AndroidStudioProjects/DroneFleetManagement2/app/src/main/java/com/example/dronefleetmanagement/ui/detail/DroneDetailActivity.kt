package com.example.dronefleetmanagement.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dronefleetmanagement.databinding.ActivityDroneDetailBinding

class DroneDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDroneDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDroneDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvDroneId.text = "Drone Detail Screen"
    }
}

