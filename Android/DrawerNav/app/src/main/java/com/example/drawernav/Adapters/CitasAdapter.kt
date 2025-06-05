package com.example.drawernav.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.drawernav.Models.Appointment
import com.example.drawernav.R
import java.text.SimpleDateFormat
import java.util.Locale

class CitasAdapter(private var appointments: List<Appointment>) :
    RecyclerView.Adapter<CitasAdapter.AppointmentViewHolder>() {

    private val dateFormat = SimpleDateFormat("EEE, dd MMM yyyy HH:mm", Locale.getDefault())

    inner class AppointmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvType: TextView = itemView.findViewById(R.id.tvAppointmentType)
        private val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        private val tvPet: TextView = itemView.findViewById(R.id.tvPetName)
        private val tvVet: TextView = itemView.findViewById(R.id.tvVetName)
        private val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)

        fun bind(appointment: Appointment) {
            tvType.text = appointment.type
            tvDate.text = dateFormat.format(appointment.date)
            tvPet.text = "Mascota: ${appointment.petName}"
            tvVet.text = "Veterinario: ${appointment.vetName}"
            tvStatus.text = appointment.status

            // Cambiar color según estado
            val statusColor = when (appointment.status) {
                "Confirmada" -> R.color.green
                "Pendiente" -> R.color.orange
                "Cancelada" -> R.color.error
                else -> R.color.grey
            }
            tvStatus.setBackgroundResource(statusColor)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_citas, parent, false)
        return AppointmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        holder.bind(appointments[position])
    }

    override fun getItemCount() = appointments.size

    fun updateData(newAppointments: List<Appointment>) {
        appointments = newAppointments
        notifyDataSetChanged()
    }
}