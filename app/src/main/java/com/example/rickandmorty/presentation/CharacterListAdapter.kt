package com.example.rickandmorty.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.rickandmorty.R
import com.example.rickandmorty.data.CharactersRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.GetAllCharactersUseCase
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class CharacterListAdapter(
    val fragmentNavigator: FragmentNavigator? = null
    //private val clickListener: ClickListener? = null
) : androidx.recyclerview.widget.ListAdapter<CharacterObject, CharacterViewHolder>(
    CharacterDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val characterView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_character_list_view, parent, false)
        return CharacterViewHolder(characterView)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        with(holder) {
            name.text = character.name
            species.text = character.species
            status.text = character.status
            gender.text = character.gender
            itemView.setOnClickListener {
                fragmentNavigator?.goToNextFragment(
                    FragmentsNames.CHARACTER_DETAILS_FRAGMENT,
                    position
                )
            }
            itemView.setOnLongClickListener {
                true
            }

            Picasso.get()
                .load(character.image)
                .into(image, object : Callback {
                    override fun onError(e: Exception?) {
                        //showToastWithError()
                    }

                    override fun onSuccess() {
                        return
                    }
                })
        }
    }

}