package com.example.rickandmorty.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rickandmorty.databinding.FragmentCharacterDetailsBinding
import com.example.rickandmorty.data.pojo.CharacterInfo
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

class CharactersListAdapter : PagingDataAdapter<CharacterInfo,
        CharactersListAdapter.ImageViewHolder>(diffCallback) {

    inner class ImageViewHolder(
        val binding: FragmentCharacterDetailsBinding
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
            FragmentCharacterDetailsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val character = getItem(position)

        holder.binding.apply {
            holder.itemView.apply {
                character?.let {
                    Picasso.get()
                        .load(character.image)
                        //.memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                        //.networkPolicy(NetworkPolicy.NO_CACHE)
                        .into(characterDetailsImage)
                    //characterDetailsId.text = character.id.toString()
                    characterDetailsName.text = character.name
                    characterDetailsStatus.text = character.status
                    characterDetailsSpecies.text = character.species
                    //haracterDetailsType.text = character.type
                    characterDetailsGender.text = character.gender
                    //characterDetailsOrigin.text = character.origin
                    //characterDetailsLocation.text = character.location
                    //characterDetailsUrl.text = character.url
                    //characterDetailsCreated.text = character.created
                }
//                val imageLink = currChar?.image
//                imageView.load(imageLink) {
//                    crossfade(true)
//                    crossfade(1000)
               }
            }
        }

    }


