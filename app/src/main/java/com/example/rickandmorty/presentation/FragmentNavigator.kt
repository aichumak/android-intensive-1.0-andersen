package com.example.rickandmorty.presentation

interface FragmentNavigator {
    fun goToNextFragment(fragment: FragmentsNames, itemId: Int)
    fun goToPrevFragment()
}