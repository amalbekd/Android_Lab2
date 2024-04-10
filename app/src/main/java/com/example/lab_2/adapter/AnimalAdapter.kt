package com.example.lab_2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_2.databinding.ItemAnimalBinding
import com.example.lab_2.model.Animal

class AnimalAdapter :
    ListAdapter<Animal, AnimalAdapter.ViewHolder>(AnimalDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAnimalBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemAnimalBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(animal: Animal) {
            with(binding) {
                animalName.text = animal.name
                animalKingdom.text = animal.taxonomy.kingdom
                animalPhylum.text = animal.taxonomy.phylum
                animalClass.text = animal.taxonomy.`class`
                animalOrder.text = animal.taxonomy.order
                animalLocation.text = animal.location?.joinToString { ", " }
            }
        }
    }
}