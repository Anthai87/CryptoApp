package com.example.mycryptoapp.ui.fragments.portfolio

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycryptoapp.R
import com.example.mycryptoapp.adapters.PortfolioAdapter
import com.example.mycryptoapp.logic.PortfolioLogic
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.models.InvestedCrypto
import com.example.mycryptoapp.models.Portfolio
import com.example.mycryptoapp.util.observeOnce
import com.example.mycryptoapp.viewmodels.PortfolioViewModel
import kotlinx.android.synthetic.main.fragment_my_portfolio.view.*
import kotlinx.android.synthetic.main.fragment_transactions.view.*
import kotlinx.coroutines.launch

class MyPortfolioFragment : Fragment() {

    private lateinit var mPortfolioViewModel: PortfolioViewModel

    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var adapter: PortfolioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPortfolioViewModel =
            ViewModelProvider(requireActivity()).get(PortfolioViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_my_portfolio, container, false)

        view.amount.text = PortfolioLogic.portfolioAmount.toString() + " USD "

        layoutManager = LinearLayoutManager(activity)
        adapter = PortfolioAdapter(listOf())

        view.portfolio_crypto_recyclerView.layoutManager = layoutManager
        view.portfolio_crypto_recyclerView.setHasFixedSize(true)
        view.portfolio_crypto_recyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readDatabase()
    }


    private fun readDatabase() {
        lifecycleScope.launch {
            mPortfolioViewModel.readPortfolio.observeOnce(viewLifecycleOwner) { database ->
                if (database.isNotEmpty()) {
                    Log.d("MyPortfolioFragment", "readDatabase called!")
                    adapter.setData(database[0].portfolio.investedCryptos)
                    PortfolioLogic.portfolio = database[0].portfolio
                } else {
                    Log.d("MyPortfolioFragment", "readDatabase called!")
                }
            }
        }
    }

}