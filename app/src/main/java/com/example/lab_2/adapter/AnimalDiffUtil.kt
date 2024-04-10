package com.example.lab_2.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.lab_2.model.Animal

class AnimalDiffUtil : DiffUtil.ItemCallback<Animal>() {
    override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
        return oldItem == newItem
    }
}