package com.example.lab_2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_2.databinding.ItemDragonBinding
import com.example.lab_2.model.Dragon


class DragonAdapter(
    private val dragons: List<Dragon>
) :
    RecyclerView.Adapter<DragonAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDragonBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = dragons.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dragons[position])
    }


    inner class ViewHolder(
        private val binding: ItemDragonBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(dragon: Dragon) {
            with(binding) {

                dragonName.text = dragon.name
                dragonTaxonomy.text = dragon.taxonomy
                dragonLocation.text = dragon.taxonomy
                dragonCharacteristic.text = dragon.characteristics

            }
        }
    }
}



//class DragonAdapter :
//    ListAdapter<Dragon, DragonAdapter.ViewHolder>(DragonDiffUtil()) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(
//            ItemDragonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        )
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(getItem(position))
//    }
//
//    inner class ViewHolder(private val binding: ItemDragonBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(dragon: Dragon) {
//            with(binding) {
//                dragonName.text = dragon.name
//                dragonTaxonomy.text = dragon.taxonomy
//                dragonLocation.text = dragon.locations.toString()
//                dragonCharacteristic.text = dragon.characteristics
//
//
//
//            }
//        }
//    }
//
//}