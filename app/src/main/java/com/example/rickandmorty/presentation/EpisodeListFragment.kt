package com.example.rickandmorty.presentation

import androidx.fragment.app.Fragment
import com.example.rickandmorty.R

class EpisodeListFragment: Fragment(R.layout.fragment_episode_list) {


    companion object {
        val FRAGMENT_EPISODE_LIST = "FRAGMENT_EPISODE_LIST"
        fun newInstance() = EpisodeListFragment()
    }

}