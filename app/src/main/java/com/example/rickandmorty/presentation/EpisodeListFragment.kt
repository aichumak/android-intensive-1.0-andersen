package com.example.rickandmorty.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentCharacterListBinding
import com.example.rickandmorty.databinding.FragmentEpisodeListBinding

class EpisodeListFragment: Fragment(R.layout.fragment_episode_list) {

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
        //setHasOptionsMenu(true)
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
        val listAdapter = viewModel?.repository?.let { EpisodeListAdapter(it) }

        binding?.let {
            it.rvEpisodeList.layoutManager = GridLayoutManager(context, 2)
            it.rvEpisodeList.adapter = listAdapter
        }
        viewModel?.episodesList?.observe(viewLifecycleOwner) {
            listAdapter?.submitList(it)
        }
    }

    companion object {
        val FRAGMENT_EPISODE_LIST = "FRAGMENT_EPISODE_LIST"
        fun newInstance() = EpisodeListFragment()
    }
}