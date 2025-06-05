package com.example.drawernav.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import Models.PacienteModel
import com.example.drawernav.R
import java.util.Calendar
import java.util.Date

class MascotasAdapter(private var mascotas: List<PacienteModel>) :
    RecyclerView.Adapter<MascotasAdapter.MascotaViewHolder>() {

    class MascotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(mascota: PacienteModel) {
            itemView.findViewById<TextView>(R.id.petName).text = mascota.nombre
            itemView.findViewById<TextView>(R.id.petSpecies).text = mascota.especie
            itemView.findViewById<TextView>(R.id.petBreed).text = mascota.raza
            itemView.findViewById<TextView>(R.id.petAge).text = "edad ${calcularEdad(mascota.fecha_nac)}"
        }

        private fun calcularEdad(fechaNac: Date): Int {
            val nacimiento = Calendar.getInstance().apply { time = fechaNac }
            val hoy = Calendar.getInstance()
            var edad = hoy.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR)
            if (hoy.get(Calendar.DAY_OF_YEAR) < nacimiento.get(Calendar.DAY_OF_YEAR)) {
                edad--
            }
            return edad
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mascotas, parent, false)
        return MascotaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
        holder.bind(mascotas[position])
    }

    override fun getItemCount() = mascotas.size

    fun updateData(newMascotas: List<PacienteModel>) {
        mascotas = newMascotas
        notifyDataSetChanged()
    }
}
