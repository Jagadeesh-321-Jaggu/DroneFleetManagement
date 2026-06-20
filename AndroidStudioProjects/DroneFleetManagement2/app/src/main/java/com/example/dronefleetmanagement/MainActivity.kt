package com.example.dronefleetmanagement

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dronefleetmanagement.databinding.ActivityMainBinding
import com.example.dronefleetmanagement.ui.adapter.DroneAdapter
import com.example.dronefleetmanagement.viewmodel.DroneViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DroneAdapter
    private lateinit var viewModel: DroneViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[DroneViewModel::class.java]

        adapter = DroneAdapter(emptyList()) { drone ->
            // Drone clicked
        }

        binding.rvDrones.layoutManager =
            LinearLayoutManager(this)

        binding.rvDrones.adapter = adapter

        viewModel.droneList.observe(this) {
            adapter.updateList(it)
        }

        // Filter Spinner

        val filterAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.filter_options,
            android.R.layout.simple_spinner_item
        )

        filterAdapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        binding.spinnerFilter.adapter = filterAdapter

        binding.spinnerFilter.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    val selected =
                        binding.spinnerFilter.selectedItem.toString()

                    viewModel.filterByStatus(selected)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

        // Sort Spinner

        val sortAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.sort_options,
            android.R.layout.simple_spinner_item
        )

        sortAdapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        binding.spinnerSort.adapter = sortAdapter

        binding.spinnerSort.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    when (position) {

                        0 -> {
                            // Default
                        }

                        1 -> {
                            viewModel.sortHighToLow()
                        }

                        2 -> {
                            viewModel.sortLowToHigh()
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

        // SearchView

        binding.searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    viewModel.searchDrone(
                        newText ?: ""
                    )

                    return true
                }
            }
        )
    }
}