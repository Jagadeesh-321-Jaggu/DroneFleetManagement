package com.example.dronefleetmanagement.data.repository

import com.example.dronefleetmanagement.data.model.Drone

class DroneRepository {

    fun getDrones(): List<Drone> {

        return listOf(

            Drone(
                "GA-001",
                "Survey Drone",
                85,
                "Flying",
                "Mysore",
                "120m",
                "25 km/h",
                "10:30 AM"
            ),

            Drone(
                "GA-002",
                "Spray Drone",
                42,
                "Idle",
                "Mandya",
                "0m",
                "0 km/h",
                "10:20 AM"
            ),

            Drone(
                "GA-003",
                "Mapping Drone",
                18,
                "Charging",
                "Bangalore",
                "0m",
                "0 km/h",
                "10:15 AM"
            ),

            Drone(
                "GA-004",
                "Inspection Drone",
                67,
                "Flying",
                "Tumkur",
                "140m",
                "30 km/h",
                "10:40 AM"
            ),

            Drone(
                "GA-005",
                "Agriculture Drone",
                95,
                "Idle",
                "Hassan",
                "0m",
                "0 km/h",
                "10:25 AM"
            )
        )
    }
}