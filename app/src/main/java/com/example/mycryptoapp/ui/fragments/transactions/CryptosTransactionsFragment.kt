package com.example.mycryptoapp.ui.fragments.transactions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.mycryptoapp.R
import com.example.mycryptoapp.adapters.CryptosAdapter
import com.example.mycryptoapp.adapters.TransactionsAdapter
import com.example.mycryptoapp.viewmodels.CryptosViewModel
import com.example.mycryptoapp.viewmodels.TransactionsViewModel
import kotlinx.coroutines.launch


class CryptosTransactionsFragment : Fragment() {

    private lateinit var mTransactionsViewModel: TransactionsViewModel
    //private val mAdapter by lazy { TransactionsAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crypto_transactions, container, false)
    }




}