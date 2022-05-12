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
import com.example.rickandmorty.databinding.FragmentLocationListBinding

class LocationListFragment: Fragment(R.layout.fragment_location_list) {

    private var binding: FragmentLocationListBinding? = null
    private var viewModel: LocationListViewModel? = null
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
        binding = FragmentLocationListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[LocationListViewModel::class.java]
        val listAdapter = viewModel?.repository?.let { LocationListAdapter(it) }

        binding?.let {
            it.rvLocationList.layoutManager = GridLayoutManager(context, 2)
            it.rvLocationList.adapter = listAdapter
        }
        viewModel?.locationsList?.observe(viewLifecycleOwner) {
            listAdapter?.submitList(it)
        }
    }

    companion object {
        val FRAGMENT_LOCATION_LIST = "FRAGMENT_LOCATION_LIST"
        fun newInstance() = LocationListFragment()
    }
}