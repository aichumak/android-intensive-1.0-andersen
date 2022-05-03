package com.example.rickandmorty.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rickandmorty.pojo.CharacterInfo

class CharacterAdapter : PagingDataAdapter<CharacterInfo,
        ImageViewHolder>(diffCallback) {


    inner class ImageViewHolder(
        val binding:
    ) :
        ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<CharacterInfo>() {
            override fun areItemsTheSame(oldItem: CharacterInfo, newItem: CharacterInfo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CharacterInfo, newItem: CharacterInfo): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            CharacterLayoutBinding.inflate(
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


}