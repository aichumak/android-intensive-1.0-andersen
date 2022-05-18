package com.example.rickandmorty.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.rickandmorty.R
import com.example.rickandmorty.data.CharactersRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.GetAllCharactersUseCase
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.util.ArrayList

class CharacterListAdapter(
    val fragmentNavigator: FragmentNavigator? = null,
    private val stringArrayList: ArrayList<String>?
) : androidx.recyclerview.widget.ListAdapter<CharacterObject, CharacterViewHolder>(
    CharacterDiffCallback()
) {
    private val repository = CharactersRepositoryImpl
    private val getAllCharactersUseCase = GetAllCharactersUseCase(repository)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val characterView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_character_list_view, parent, false)
        return CharacterViewHolder(characterView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        with(holder) {
            name.text = ("Name: ${character.name}")
            species.text = ("Species: ${character.species}")
            status.text = ("Status: ${character.status}")
            gender.text = ("Gender: ${character.gender}")
            itemView.setOnClickListener {
                fragmentNavigator?.goToNextFragment(
                    FragmentsNames.CHARACTER_DETAILS_FRAGMENT,
                    character.id
                )
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