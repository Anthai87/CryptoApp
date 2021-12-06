package com.example.mycryptoapp.ui.fragments.portfolio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mycryptoapp.R
import com.example.mycryptoapp.logic.PortfolioLogic
import kotlinx.android.synthetic.main.fragment_my_portfolio.view.*

class MyPortfolioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_my_portfolio, container, false)

        view.amount.text = PortfolioLogic.portfolioAmount.toString() + " USD "

        return view
    }

}