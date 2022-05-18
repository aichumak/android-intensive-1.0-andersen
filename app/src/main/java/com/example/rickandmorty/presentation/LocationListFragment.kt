package com.example.rickandmorty.presentation

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentLocationListBinding
import com.example.rickandmorty.domain.locations.LocationObject
import java.util.*

class LocationListFragment : Fragment(R.layout.fragment_location_list) {

    private var binding: FragmentLocationListBinding? = null
    private var viewModel: LocationListViewModel? = null
    private var fragmentNavigator: FragmentNavigator? = null

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
        binding = FragmentLocationListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[LocationListViewModel::class.java]
        viewModel?.updateRequiredLocations()
        val listAdapter = LocationListAdapter(fragmentNavigator)
        binding?.let {
            it.rvLocationList.layoutManager = GridLayoutManager(context, 2)
            it.rvLocationList.adapter = listAdapter
            it.filterApplyButton.setOnClickListener {
                fragmentNavigator?.goToFilterDialogForResult(viewModel)
            }
        }
        viewModel?.locationsList?.observe(viewLifecycleOwner) {
            listAdapter.submitList(it)
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
                    it.restoreLocationsList()
                    val list = it.locationsList
                    val searchText = p0?.lowercase(Locale.getDefault()) ?: ""
                    val newList =
                        sortedSetOf<LocationObject>({ o1, o2 -> o1.id.compareTo(o2.id) })

                    if (searchText.isNotEmpty()) {
                        list.value?.forEach { itValue ->
                            if (itValue.name.lowercase(Locale.getDefault())
                                    .contains(searchText) ||
                                itValue.type.lowercase(Locale.getDefault())
                                    .contains(searchText) ||
                                itValue.dimension.lowercase(Locale.getDefault())
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
        val LOCATION_ARRAY = "LOCATION_ARRAY"
        val FRAGMENT_LOCATION_LIST = "FRAGMENT_LOCATION_LIST"
        fun newInstance(arrayList: ArrayList<String>?): LocationListFragment {
            val args = Bundle().apply {
                putStringArrayList(LOCATION_ARRAY, arrayList)
            }
            val fragment = LocationListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}