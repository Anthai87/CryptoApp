package com.example.mycryptoapp.ui.fragments.favorites

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycryptoapp.R
import com.example.mycryptoapp.adapters.CryptosAdapter
import com.example.mycryptoapp.adapters.TransactionsAdapter
import com.example.mycryptoapp.util.observeOnce
import com.example.mycryptoapp.viewmodels.CryptosViewModel
import com.example.mycryptoapp.viewmodels.TransactionsViewModel
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