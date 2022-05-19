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
import com.example.rickandmorty.databinding.FragmentLocationDetailsBinding

class LocationFragment : Fragment(R.layout.fragment_location_details) {

    private var binding: FragmentLocationDetailsBinding? = null
    private var viewModel: LocationViewModel? = null
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
        binding = FragmentLocationDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[LocationViewModel::class.java]
        viewModel?.location?.observe(viewLifecycleOwner) {
            binding?.locationDetailsName?.text = ("Name: ${it.name}")
            binding?.locationDetailsType?.text = ("Type: ${it.type}")
            binding?.locationDetailsDimension?.text = ("Dimension: ${it.dimension}")
            childFragmentManager.beginTransaction().run {
                val fragment = CharacterListFragment.newInstance(it.residents)
                childFragmentManager.beginTransaction().run {
                    replace(
                        R.id.location_details_fragment_container,
                        fragment,
                        CharacterListFragment.FRAGMENT_CHARACTER_LIST
                    )
                    commit()
                }
            }
        }
        arguments?.let {
            viewModel?.getSingleLocation(it.getInt(LOCATION_ID))
        }
    }

    companion object {
        private const val LOCATION_ID = "LOCATION_DETAILS_ID"
        const val FRAGMENT_LOCATION_DETAILS_TAG = "FRAGMENT_LOCATION_DETAILS_TAG"

        fun newInstance(locationId: Int): LocationFragment {
            val args = Bundle().apply {
                putInt(LOCATION_ID, locationId)
            }
            val fragment = LocationFragment()
            fragment.arguments = args
            return fragment
        }
    }
}