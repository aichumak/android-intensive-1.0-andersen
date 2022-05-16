package com.example.rickandmorty.presentation

import androidx.lifecycle.ViewModel

interface FragmentNavigator {
    fun goToNextFragment(fragment: FragmentsNames, itemId: Int)
    fun goToPrevFragment()
    fun goToFilterDialogForResult(viewModel: ViewModel?)
}