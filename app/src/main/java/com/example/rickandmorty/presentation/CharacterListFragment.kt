package com.example.rickandmorty.presentation

import androidx.fragment.app.Fragment
import com.example.rickandmorty.R

class CharacterListFragment: Fragment(R.layout.fragment_character_list) {



    companion object {
        val FRAGMENT_CHARACTER_LIST = "FRAGMENT_CHARACTER_LIST"
        fun newInstance() = CharacterListFragment()
    }
}