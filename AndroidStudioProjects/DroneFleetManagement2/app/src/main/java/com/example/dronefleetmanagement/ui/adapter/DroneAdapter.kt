package com.example.dronefleetmanagement.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dronefleetmanagement.data.model.Drone
import com.example.dronefleetmanagement.databinding.ItemDroneBinding

class DroneAdapter(
    private var droneList: List<Drone>,
    private val onItemClick: (Drone) -> Unit
) : RecyclerView.Adapter<DroneAdapter.DroneViewHolder>() {

    inner class DroneViewHolder(
        val binding: ItemDroneBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DroneViewHolder {

        val binding = ItemDroneBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return DroneViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: DroneViewHolder,
        position: Int
    ) {

        val drone = droneList[position]

        holder.binding.tvDroneId.text = drone.droneId
        holder.binding.tvDroneName.text = drone.droneName
        holder.binding.tvStatus.text = drone.status
        holder.binding.tvLocation.text = drone.location
        holder.binding.tvBattery.text = "${drone.battery}%"

        holder.binding.progressBattery.progress =
            drone.battery

        when {

            drone.battery > 50 ->
                holder.binding.tvBatteryStatus.text =
                    "Healthy"

            drone.battery in 20..50 ->
                holder.binding.tvBatteryStatus.text =
                    "Warning"

            else ->
                holder.binding.tvBatteryStatus.text =
                    "Critical"
        }

        holder.itemView.setOnClickListener {
            onItemClick(drone)
        }
    }

    override fun getItemCount(): Int {
        return droneList.size
    }

    fun updateList(newList: List<Drone>) {
        droneList = newList
        notifyDataSetChanged()
    }
}