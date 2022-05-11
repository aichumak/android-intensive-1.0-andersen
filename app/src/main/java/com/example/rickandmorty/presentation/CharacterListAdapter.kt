package com.example.rickandmorty.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.rickandmorty.R
import com.example.rickandmorty.data.CharactersRepositoryImpl
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.CharactersRepository
import com.example.rickandmorty.domain.characters.GetAllCharactersUseCase
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class CharacterListAdapter(
    repository: CharactersRepository
    //private val fragmentNavigator: FragmentNavigator
    //private val clickListener: ClickListener? = null
) : androidx.recyclerview.widget.ListAdapter<CharacterObject, CharacterViewHolder>(
    CharacterDiffCallback()
) {
    //private val repository = CharactersRepositoryImpl(context, compositeDisposable)
    private val getAllCharactersUseCase = GetAllCharactersUseCase(repository)
    //private val getCharacterUseCase = GetCharacterUseCase(repository)

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
//                fragmentNavigator?.goFromContactListFragmentToContactFragment(contact.id)
//                viewModel?.savedSearchText = ""
            }
            itemView.setOnLongClickListener {
//                clickListener?.removeContact(contact.id)
                true
            }

            Picasso.get()
                .load(character.image)
                //.memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                //.networkPolicy(NetworkPolicy.NO_CACHE)
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