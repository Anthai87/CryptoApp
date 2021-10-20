package com.example.mycryptoapp.ui.fragments.cryptos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mycryptoapp.R
import kotlinx.android.synthetic.main.fragment_cryptos.view.*


class CryptosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cryptos, container, false)

        view.shimmer_recycler_view.showShimmer()

        return view
    }

}