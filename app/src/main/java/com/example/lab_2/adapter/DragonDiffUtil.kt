package com.example.lab_2.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.lab_2.model.Dragon

class DragonDiffUtil : DiffUtil.ItemCallback<Dragon>() {
    override fun areItemsTheSame(oldItem: Dragon, newItem: Dragon): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Dragon, newItem: Dragon): Boolean {
        return oldItem == newItem
    }
}