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
import com.example.rickandmorty.databinding.FragmentCharacterDetailsBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class CharacterFragment : Fragment(R.layout.fragment_character_details) {

    private var binding: FragmentCharacterDetailsBinding? = null
    private var viewModel: CharacterViewModel? = null
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
        binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
        arguments?.let {
            viewModel?.getSingleCharacter(it.getInt(CHARACTER_ID))
        }
        viewModel?.character?.observe(viewLifecycleOwner) {
            Picasso.get()
                .load(it.image)
                .into(binding?.characterDetailsImage, object : Callback {
                    override fun onError(e: Exception?) {
                    }

                    override fun onSuccess() {
                        return
                    }
                })
            binding?.characterDetailsName?.text = ("Name: ${it.name}")
            binding?.characterDetailsStatus?.text = ("Status: ${it.status}")
            binding?.characterDetailsSpecies?.text = ("Species: ${it.species}")
            binding?.characterDetailsType?.text = ("Type: ${it.type}")
            binding?.characterDetailsGender?.text = ("Name: ${it.gender}")
            binding?.characterDetailsOrigin?.text = ("Origin: ${it.origin.name}")
            binding?.characterDetailsLocation?.text = ("Location: ${it.location.name}")
            childFragmentManager.beginTransaction().run {
                val fragment = EpisodeListFragment.newInstance(it.episode)
                childFragmentManager.beginTransaction().run {
                    replace(
                        R.id.character_details_fragment_container,
                        fragment,
                        CharacterListFragment.FRAGMENT_CHARACTER_LIST
                    )
                    commit()
                }
            }
        }
    }

    companion object {
        private const val CHARACTER_ID = "CHARACTER_ID"
        const val FRAGMENT_CHARACTER_DETAILS_TAG = "FRAGMENT_CHARACTER_DETAILS_TAG"

        fun newInstance(characterId: Int): CharacterFragment {
            val args = Bundle().apply {
                putInt(CHARACTER_ID, characterId)
            }
            val fragment = CharacterFragment()
            fragment.arguments = args
            return fragment
        }
    }

}