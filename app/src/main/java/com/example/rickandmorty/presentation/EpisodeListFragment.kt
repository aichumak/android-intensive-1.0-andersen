package com.example.rickandmorty.presentation

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentEpisodeListBinding
import com.example.rickandmorty.domain.episodes.EpisodeObject
import java.util.*

class EpisodeListFragment : Fragment(R.layout.fragment_episode_list) {

    private var binding: FragmentEpisodeListBinding? = null
    private var viewModel: EpisodeListViewModel? = null
    private var fragmentNavigator: FragmentNavigator? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentNavigator) fragmentNavigator = context
        //if (context is ClickListener) clickListener = context
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
        binding = FragmentEpisodeListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[EpisodeListViewModel::class.java]
        arguments?.let {
            viewModel?.updateRequiredEpisodes(it.getStringArrayList(EPISODE_ARRAY))
            if (it.getStringArrayList(EPISODE_ARRAY) != null) {
                binding?.filterApplyButton?.hide()
            }
            val listAdapter = EpisodeListAdapter(fragmentNavigator)
            binding?.let { itBinding ->
                itBinding.rvEpisodeList.layoutManager = GridLayoutManager(context, 2)
                itBinding.rvEpisodeList.adapter = listAdapter
                itBinding.filterApplyButton.setOnClickListener {
                    fragmentNavigator?.goToFilterDialogForResult(viewModel)
                }
            }
            viewModel?.episodesList?.observe(viewLifecycleOwner) { itList ->
                listAdapter.submitList(itList)
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
                    it.restoreEpisodesList()
                    val list = it.episodesList
                    val searchText = p0?.lowercase(Locale.getDefault()) ?: ""
                    val newList =
                        sortedSetOf<EpisodeObject>({ o1, o2 -> o1.id.compareTo(o2.id) })

                    if (searchText.isNotEmpty()) {
                        list.value?.forEach { itValue ->
                            if (itValue.name.lowercase(Locale.getDefault())
                                    .contains(searchText) ||
                                itValue.episode.lowercase(Locale.getDefault())
                                    .contains(searchText) ||
                                itValue.air_date.lowercase(Locale.getDefault())
                                    .contains(searchText)
                            ) {
                                newList.add(itValue)
                            }
                        }
                        it.replaceListForSearch(newList)
                    }
                    return false
                }
            })
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    companion object {
        val EPISODE_ARRAY = "EPISODE_ARRAY"
        val FRAGMENT_EPISODE_LIST = "FRAGMENT_EPISODE_LIST"
        fun newInstance(arrayList: ArrayList<String>?): EpisodeListFragment {
            val args = Bundle().apply {
                putStringArrayList(EPISODE_ARRAY, arrayList)
            }
            val fragment = EpisodeListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}