package com.example.mycryptoapp.ui.fragments.portfolio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycryptoapp.R
import com.example.mycryptoapp.adapters.PortfolioAdapter
import com.example.mycryptoapp.adapters.TransactionsAdapter
import com.example.mycryptoapp.logic.PortfolioLogic
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.models.InvestedCrypto
import com.example.mycryptoapp.viewmodels.PortfolioViewModel
import com.example.mycryptoapp.viewmodels.TransactionsViewModel
import kotlinx.android.synthetic.main.fragment_my_portfolio.view.*
import kotlinx.android.synthetic.main.fragment_transactions.view.*

class MyPortfolioFragment : Fragment() {

    private lateinit var mPortfolioViewModel: PortfolioViewModel

    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var portfolioAdapter: PortfolioAdapter

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
        portfolioAdapter = PortfolioAdapter(listOf(
            InvestedCrypto(Crypto("","","","","","","1234","","","btc","",""), 55.5),
            InvestedCrypto(Crypto("","","","","","","1234","","","eth","",""), 50.5),
            ))

        view.portfolio_crypto_recyclerView.layoutManager = layoutManager
        view.portfolio_crypto_recyclerView.setHasFixedSize(true)
        view.portfolio_crypto_recyclerView.adapter = portfolioAdapter

        return view
    }

}