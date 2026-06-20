# Drone Fleet Management

## Overview

Drone Fleet Management is an Android application developed using Kotlin and MVVM Architecture. The application displays a list of drones and allows users to view drone information, filter drones by status, sort drones by battery percentage, and monitor battery health.

## Features

* Display list of drones using RecyclerView
* MVVM Architecture
* Repository Pattern
* ViewBinding
* Filter drones by status:

  * Flying
  * Idle
  * Charging
* Sort drones by battery:

  * High to Low
  * Low to High
* Battery Health Indicator:

  * Healthy (>50%)
  * Warning (20%-50%)
  * Critical (<20%)
* Clean folder structure and reusable components

## Tech Stack

* Kotlin
* Android SDK
* RecyclerView
* ViewModel
* LiveData
* ViewBinding

## Project Structure

* data

  * model
  * repository
* ui

  * adapter
  * detail
* viewmodel

## Sample Data

The application uses locally stored drone data for demonstration purposes.

## Author

Jagadeesh

