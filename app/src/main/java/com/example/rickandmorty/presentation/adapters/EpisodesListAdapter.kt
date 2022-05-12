package com.example.rickandmorty.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.FragmentEpisodeListBinding
import com.example.rickandmorty.data.pojo.EpisodeInfo
import com.example.rickandmorty.domain.episodes.EpisodeObject

class EpisodesListAdapter : PagingDataAdapter<EpisodeObject,
        EpisodesListAdapter.ImageViewHolder>(diffCallback) {


    inner class ImageViewHolder(
        val binding: FragmentEpisodeListBinding
    ) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<EpisodeObject>() {
            override fun areItemsTheSame(oldItem: EpisodeObject, newItem: EpisodeObject): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: EpisodeObject, newItem: EpisodeObject): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            FragmentEpisodeListBinding.inflate(
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


