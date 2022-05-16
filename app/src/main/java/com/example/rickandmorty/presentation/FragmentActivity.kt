package com.example.rickandmorty.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.R

class FragmentActivity : AppCompatActivity(), FragmentNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        if (supportFragmentManager.backStackEntryCount == 0) {
            supportFragmentManager.beginTransaction().run {
                val fragment = MainFragment.newInstance()
                replace(
                    R.id.main_fragment_container,
                    fragment,
                    MainFragment.FRAGMENT_MAIN
                )
                addToBackStack(MainFragment.FRAGMENT_MAIN)
                commit()
            }
        } else {
            val index = supportFragmentManager.backStackEntryCount - 1
            val backEntry = supportFragmentManager.getBackStackEntryAt(index)
            val tag = backEntry.name
            supportFragmentManager.popBackStack(tag, 0)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        } else {
            goToPrevFragment()
        }
    }

    override fun goToNextFragment(fragment: FragmentsNames, itemId: Int) {
        when (fragment) {
            FragmentsNames.CHARACTER_DETAILS_FRAGMENT -> runFragment(
                CharacterFragment.newInstance(
                    itemId
                )
            )
            FragmentsNames.EPISODE_DETAILS_FRAGMENT -> runFragment(
                EpisodeFragment.newInstance(
                    itemId
                )
            )
            FragmentsNames.LOCATION_DETAILS_FRAGMENT -> runFragment(
                LocationFragment.newInstance(
                    itemId
                )
            )
        }
    }

    override fun goToPrevFragment() {
        val index = supportFragmentManager.backStackEntryCount - 1
        val backEntry = supportFragmentManager.getBackStackEntryAt(index)
        val tag = backEntry.name
        supportFragmentManager.popBackStack(tag, 0)
    }

    override fun goToFilterDialogForResult(viewModel: ViewModel?) {
        viewModel?.let {
            val filterDialog = FilterDialog(viewModel)
            filterDialog.show(supportFragmentManager, "filter_dialog")
        }
    }

    private fun runFragment(fragment: Fragment) {
        val fragmentTag = when (fragment) {
            is CharacterFragment -> CharacterFragment.FRAGMENT_CHARACTER_DETAILS_TAG
            is EpisodeFragment -> EpisodeFragment.FRAGMENT_EPISODE_DETAILS_TAG
            is LocationFragment -> LocationFragment.FRAGMENT_LOCATION_DETAILS_TAG
            else -> null
        }

        supportFragmentManager.beginTransaction().run {
            replace(
                R.id.main_fragment_container,
                fragment,
                fragmentTag
            )
            addToBackStack(fragmentTag)
            commit()
        }
    }
}