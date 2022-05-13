package com.example.rickandmorty.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentNavigationBinding

class NavigationFragment : Fragment(R.layout.fragment_navigation) {
    private var viewModel: NavigationViewModel? = null
    private var binding: FragmentNavigationBinding? = null
    private var fragmentNavigator: FragmentNavigator? = null
    //private var clickListener: ClickListener? = null
    // private var contactListAdapter: ContactListAdapter? = null

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
        binding = FragmentNavigationBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[NavigationViewModel::class.java]

        childFragmentManager.beginTransaction().run {
            val fragment = CharacterListFragment.newInstance()
            replace(
                R.id.list_view_fragment_container,
                fragment,
                CharacterListFragment.FRAGMENT_CHARACTER_LIST
            )
            //addToBackStack(CharacterListFragment.FRAGMENT_CHARACTER_LIST)
            commit()

        }

        binding?.navigationView?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_characters_list -> {
                    runFragment(CharacterListFragment.newInstance())
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_locations_list -> {
                    runFragment(LocationListFragment.newInstance())
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_episodes_list -> {
                    runFragment(EpisodeListFragment.newInstance())
                    return@setOnItemSelectedListener true
                }
            }
            return@setOnItemSelectedListener false
        }
    }

    private fun runFragment(fragment: Fragment) {
        val fragmentTag = getFragmentTag(fragment)

        childFragmentManager.beginTransaction().run {
            replace(
                R.id.list_view_fragment_container,
                fragment,
                fragmentTag
            )
            addToBackStack(fragmentTag)
            commit()
        }
    }

    private fun getFragmentTag(fragment: Fragment): String {
        when (fragment) {
            is CharacterListFragment -> CharacterListFragment.FRAGMENT_CHARACTER_LIST
            is LocationListFragment -> LocationListFragment.FRAGMENT_LOCATION_LIST
            is EpisodeListFragment -> EpisodeListFragment.FRAGMENT_EPISODE_LIST
        }
        return ""
    }

    companion object {
        val FRAGMENT_NAVIGATION = "FRAGMENT_NAVIGATION"
        fun newInstance() = NavigationFragment()
    }
}