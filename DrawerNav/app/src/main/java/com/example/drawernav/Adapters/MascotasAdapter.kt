package com.example.drawernav.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.drawernav.Models.Pet
import com.example.drawernav.R

class MascotasAdapter(private var pets: List<Pet>) :
    RecyclerView.Adapter<MascotasAdapter.PetViewHolder>() {

    class PetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pet: Pet) {
            itemView.findViewById<TextView>(R.id.petName).text = pet.name
            itemView.findViewById<TextView>(R.id.petSpecies).text = pet.species
            itemView.findViewById<TextView>(R.id.petBreed).text = pet.breed
            itemView.findViewById<TextView>(R.id.petAge).text = "edad "+pet.age.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mascotas, parent, false)
        return PetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        holder.bind(pets[position])
    }

    override fun getItemCount() = pets.size

    fun updateData(newPets: List<Pet>) {
        pets = newPets
        notifyDataSetChanged()
    }
}
