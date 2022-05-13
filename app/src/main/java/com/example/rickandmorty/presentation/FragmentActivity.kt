package com.example.rickandmorty.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.rickandmorty.R

class FragmentActivity : AppCompatActivity(), FragmentNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        if (supportFragmentManager.backStackEntryCount == 0) {
            supportFragmentManager.beginTransaction().run {
                val fragment = NavigationFragment.newInstance()
                replace(
                    R.id.main_fragment_container,
                    fragment,
                    NavigationFragment.FRAGMENT_NAVIGATION
                )
                addToBackStack(NavigationFragment.FRAGMENT_NAVIGATION)
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
            FragmentsNames.CHARACTER_DETAILS_FRAGMENT -> runFragment(CharacterFragment.newInstance(itemId))
            FragmentsNames.EPISODE_DETAILS_FRAGMENT -> runFragment(EpisodeFragment.newInstance(itemId))
            FragmentsNames.LOCATION_DETAILS_FRAGMENT -> runFragment(LocationFragment.newInstance(itemId))
        }
    }

    override fun goToPrevFragment() {
        supportFragmentManager.popBackStack()
    }

    private fun runFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().run {
            replace(
                R.id.main_fragment_container,
                fragment,
                when(fragment){
                    is CharacterFragment -> CharacterFragment.FRAGMENT_CHARACTER_DETAILS_TAG
                    is EpisodeFragment -> EpisodeFragment.FRAGMENT_EPISODE_DETAILS_TAG
                    is LocationFragment -> LocationFragment.FRAGMENT_LOCATION_DETAILS_TAG
                    else -> null
                }
            )
            addToBackStack(NavigationFragment.FRAGMENT_NAVIGATION)
            commit()
        }
    }
}