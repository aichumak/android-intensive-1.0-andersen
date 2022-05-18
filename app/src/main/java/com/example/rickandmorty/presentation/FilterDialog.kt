package com.example.rickandmorty.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.databinding.CharactersFilterCardviewBinding
import com.example.rickandmorty.databinding.EpisodesFilterCardviewBinding
import com.example.rickandmorty.databinding.LocationsFilterCardviewBinding


class FilterDialog(private val viewModel: ViewModel?) : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return when (viewModel) {
            is CharacterListViewModel -> {
                val binding = CharactersFilterCardviewBinding.inflate(inflater, container, false)
                binding.filterCancelButton.setOnClickListener {
                    viewModel.getFilteredData(null)
                    dismiss()
                }
                binding.filterApplyButton.setOnClickListener {
                    val selectedID = binding.radioGroup.checkedRadioButtonId
                    val radio = binding.root.findViewById<RadioButton>(selectedID)
                    when (selectedID) {
                        binding.charactersFilterNameCheckBox.id -> viewModel.getFilteredData(
                            radio.text.toString() to binding.charactersFilterNameEditText.text.toString()
                        )
                        binding.charactersFilterStatusCheckBox.id -> viewModel.getFilteredData(
                            radio.text.toString() to binding.charactersFilterStatusEditText.text.toString()
                        )
                        binding.charactersFilterSpeciesCheckBox.id -> viewModel.getFilteredData(
                            radio.text.toString() to binding.charactersFilterSpeciesEditText.text.toString()
                        )
                        binding.charactersFilterTypeCheckBox.id -> viewModel.getFilteredData(
                            radio.text.toString() to binding.charactersFilterTypeEditText.text.toString()
                        )
                        binding.charactersFilterGenderCheckBox.id -> viewModel.getFilteredData(
                            radio.text.toString() to binding.charactersFilterGenderTextView.text.toString()
                        )
                    }
                    dismiss()
                }
                binding.root
            }

            is EpisodeListViewModel -> {
                val binding = EpisodesFilterCardviewBinding.inflate(inflater, container, false)
                binding.filterCancelButton.setOnClickListener {
                    viewModel.getFilteredData(null)
                    dismiss()
                }
                binding.filterApplyButton.setOnClickListener {
                    val selectedID = binding.radioGroup.checkedRadioButtonId
                    val radio = binding.root.findViewById<RadioButton>(selectedID)
                    when (selectedID) {
                        binding.episodesFilterNameCheckBox.id -> viewModel.getFilteredData(
                            radio.text.toString() to binding.episodesFilterNameEditText.text.toString()
                        )
                        binding.episodesFilterEpisodeCheckBox.id -> viewModel.getFilteredData(
                            radio.text.toString() to binding.episodesFilterNameEditText.text.toString()
                        )
                    }
                    dismiss()
                }
                binding.root
            }

            is LocationListViewModel -> {
                val binding = LocationsFilterCardviewBinding.inflate(inflater, container, false)
                binding.filterCancelButton.setOnClickListener {
                    viewModel.getFilteredData(null)
                    dismiss()
                }
                binding.filterApplyButton.setOnClickListener {
                    val selectedID = binding.radioGroup.checkedRadioButtonId
                    val radio = binding.root.findViewById<RadioButton>(selectedID)
                    when (selectedID) {
                        binding.locationsFilterNameCheckBox.id -> viewModel.getFilteredData(
                            radio.text.toString() to binding.locationsFilterNameEditText.text.toString()
                        )
                        binding.locationsFilterDimensionCheckBox.id -> viewModel.getFilteredData(
                            radio.text.toString() to binding.locationsFilterDimensionEditText.text.toString()
                        )
                        binding.locationsFilterTypeCheckBox.id -> viewModel.getFilteredData(
                            radio.text.toString() to binding.locationsFilterTypeEditText.text.toString()
                        )
                    }
                    dismiss()
                }
                binding.root
            }
            else -> null
        }
    }
}