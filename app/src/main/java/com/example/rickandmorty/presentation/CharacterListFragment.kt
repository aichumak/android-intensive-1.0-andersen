package com.example.rickandmorty.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.R
import com.example.rickandmorty.api.CharactersApiFactory
import com.example.rickandmorty.databinding.FragmentCharacterListBinding
import com.example.rickandmorty.presentation.adapters.CharactersListAdapter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CharacterListFragment : Fragment(R.layout.fragment_character_list) {
    private var binding: FragmentCharacterListBinding? = null
    private var viewModel: CharacterListViewModel? = null
    private var fragmentNavigator: FragmentNavigator? = null
    //private val compositeDisposable = CompositeDisposable()


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
        binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CharacterListViewModel::class.java]
        val listAdapter = CharactersListAdapter()

        binding?.let {
            it.rvCharacterList.layoutManager = GridLayoutManager(context, 2)
            it.rvCharacterList.adapter = CharactersListAdapter()
        }
       viewModel?.charactersList?.observe(viewLifecycleOwner) {
       //listAdapter.submitData(it)
        }

        val res = viewModel?.charactersList

//        val disposable = CharactersApiFactory.apiService.getCharactersInfoList(5)
//            .subscribeOn(Schedulers.io())
//            .subscribe({
//                if (it != null) {
//                    //db.coinPriceInfoDao().insertPriceList(it)
//                    Log.d("Test_of_loading_data", it.toString())
//                }
//            }, {
//                Log.d("Test_of_loading_data", it.message.toString())
//            })
//
//        compositeDisposable.add(disposable)

    }

//    override fun onDestroy() {
//        super.onDestroy()
//        compositeDisposable.dispose()
//
//    }


    companion object {
        val FRAGMENT_CHARACTER_LIST = "FRAGMENT_CHARACTER_LIST"
        fun newInstance() = CharacterListFragment()
    }
}