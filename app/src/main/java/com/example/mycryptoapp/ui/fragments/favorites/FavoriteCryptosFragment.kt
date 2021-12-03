package com.example.mycryptoapp.ui.fragments.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mycryptoapp.R
import kotlinx.coroutines.launch


class FavoriteCryptosFragment : Fragment() {

    //private val mAdapter by lazy { TransactionsAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // mTransactionsViewModel = ViewModelProvider(requireActivity()).get(TransactionsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_cryptos, container, false)
    }



}