package com.example.rickandmorty.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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


    override fun goToCharacterListFragment() {
        TODO("Not yet implemented")
    }

    override fun goToLocationListFragment() {
        TODO("Not yet implemented")
    }

    override fun goToEpisodeListFragment() {
        TODO("Not yet implemented")
    }
}