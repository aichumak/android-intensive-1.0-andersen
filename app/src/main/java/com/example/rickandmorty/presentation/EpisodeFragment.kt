package com.example.rickandmorty.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentEpisodeDetailsBinding

class EpisodeFragment : Fragment(R.layout.fragment_episode_details) {

    private var binding: FragmentEpisodeDetailsBinding? = null
    private var viewModel: EpisodeViewModel? = null
    private var fragmentNavigator: FragmentNavigator? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentNavigator) fragmentNavigator = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEpisodeDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[EpisodeViewModel::class.java]
        viewModel?.episode?.observe(viewLifecycleOwner) {
            binding?.episodeDetailsName?.text = ("Name: ${it.name}")
            binding?.episodeDetailsAirDate?.text = ("Air date: ${it.air_date}")
            binding?.episodeDetailsEpisode?.text = ("Episode: ${it.episode}")
            childFragmentManager.beginTransaction().run {
                val fragment = CharacterListFragment.newInstance(it.characters)
                childFragmentManager.beginTransaction().run {
                    replace(
                        R.id.episode_details_fragment_container,
                        fragment,
                        CharacterListFragment.FRAGMENT_CHARACTER_LIST
                    )
                    commit()
                }
            }

        }
        arguments?.let {
            viewModel?.getSingleEpisode(it.getInt(EPISODE_ID))
        }
    }

    companion object {
        private const val EPISODE_ID = "EPISODE_DETAILS_ID"
        const val FRAGMENT_EPISODE_DETAILS_TAG = "FRAGMENT_EPISODE_DETAILS_TAG"

        fun newInstance(episodeId: Int): EpisodeFragment {
            val args = Bundle().apply {
                putInt(EPISODE_ID, episodeId)
            }
            val fragment = EpisodeFragment()
            fragment.arguments = args
            return fragment
        }
    }

}