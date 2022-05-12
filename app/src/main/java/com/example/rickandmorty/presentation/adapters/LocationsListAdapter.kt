package com.example.rickandmorty.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.FragmentLocationListBinding
import com.example.rickandmorty.data.pojo.LocationInfo
import com.example.rickandmorty.domain.locations.LocationObject

class LocationsListAdapter : PagingDataAdapter<LocationObject,
        LocationsListAdapter.ImageViewHolder>(diffCallback) {


    inner class ImageViewHolder(
        val binding: FragmentLocationListBinding
    ) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<LocationObject>() {
            override fun areItemsTheSame(oldItem: LocationObject, newItem: LocationObject): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: LocationObject, newItem: LocationObject): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            FragmentLocationListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currChar = getItem(position)

        holder.binding.apply {

            holder.itemView.apply {
//                tvDescription.text = "${currChar?.name}"
//
//                val imageLink = currChar?.image
//                imageView.load(imageLink) {
//                    crossfade(true)
//                    crossfade(1000)
            }
        }
    }

}


