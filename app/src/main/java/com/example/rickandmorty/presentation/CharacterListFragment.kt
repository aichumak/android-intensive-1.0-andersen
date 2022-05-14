package com.example.rickandmorty.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentCharacterListBinding

class CharacterListFragment : Fragment(R.layout.fragment_character_list) {
    private var binding: FragmentCharacterListBinding? = null
    private var viewModel: CharacterListViewModel? = null
    private var fragmentNavigator: FragmentNavigator? = null
    private var progressBar: ProgressBar? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentNavigator) fragmentNavigator = context
        //if (context is ClickListener) clickListener = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CharacterListViewModel::class.java]
        arguments?.let {
            viewModel?.updateArrayCharacters(it.getStringArrayList(CHARACTERS_ARRAY))
        }

        val listAdapter = CharacterListAdapter(fragmentNavigator)

        binding?.let {
            it.rvCharacterList.layoutManager = GridLayoutManager(context, 2)
            it.rvCharacterList.adapter = listAdapter
        }
        viewModel?.charactersList?.observe(viewLifecycleOwner) {
            listAdapter.submitList(it)
        }


    }

    companion object {
        val CHARACTERS_ARRAY = "CHARACTERS_ARRAY"
        val FRAGMENT_CHARACTER_LIST = "FRAGMENT_CHARACTER_LIST"
        fun newInstance(arrayList: ArrayList<String>?): CharacterListFragment {
            val args = Bundle().apply {
                putStringArrayList(CHARACTERS_ARRAY, arrayList)
            }
            val fragment = CharacterListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}