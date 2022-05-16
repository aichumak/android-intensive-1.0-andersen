package com.example.rickandmorty.presentation

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.ProgressBar
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentCharacterListBinding
import com.example.rickandmorty.domain.characters.CharacterObject
import java.util.*

class CharacterListFragment : Fragment(R.layout.fragment_character_list) {
    private var binding: FragmentCharacterListBinding? = null
    private var viewModel: CharacterListViewModel? = null
    private var fragmentNavigator: FragmentNavigator? = null
    private var progressBar: ProgressBar? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentNavigator) fragmentNavigator = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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
            viewModel?.updateRequiredCharacters(it.getStringArrayList(CHARACTERS_ARRAY))
            if (it.getStringArrayList(CHARACTERS_ARRAY) != null) {
                binding?.filterApplyButton?.hide()
            }
            val listAdapter =
                CharacterListAdapter(fragmentNavigator, it.getStringArrayList(CHARACTERS_ARRAY))
            binding?.let { itBinding ->
                itBinding.rvCharacterList.layoutManager = GridLayoutManager(context, 2)
                itBinding.rvCharacterList.adapter = listAdapter
            }
            viewModel?.charactersList?.observe(viewLifecycleOwner) { itList ->
                listAdapter.submitList(itList)
            }
            binding?.filterApplyButton?.setOnClickListener {
                fragmentNavigator?.goToFilterDialogForResult(viewModel)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu.findItem(R.id.search_action)
        val searchView = searchItem.actionView as SearchView

        viewModel?.let {
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    //it.updateRequiredCharacters(null)
                    val list = it.charactersList
                    val searchText = p0?.lowercase(Locale.getDefault()) ?: ""
                    val newList =
                        sortedSetOf<CharacterObject>({ o1, o2 -> o1.id.compareTo(o2.id) })

                    if (searchText.isNotEmpty()) {
                        list?.value?.forEach { itValue ->
                            if (itValue.name.lowercase(Locale.getDefault())
                                    .contains(searchText) ||
                                itValue.species.lowercase(Locale.getDefault())
                                    .contains(searchText) ||
                                itValue.status.lowercase(Locale.getDefault())
                                    .contains(searchText) ||
                                itValue.gender.lowercase(Locale.getDefault()).contains(searchText)
                            ) {
                                newList.add(itValue)
                            }
                        }
                        //it.replaceListForSearch(newList)
                    }
                    return false
                }
            })
        }
        super.onCreateOptionsMenu(menu, inflater)
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