package com.example.mycryptoapp.ui.fragments.cryptooverview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import coil.load
import com.example.mycryptoapp.databinding.FragmentCryptoOverviewBinding
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.util.Constants
import com.example.mycryptoapp.viewmodels.PortfolioViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptoOverviewFragment : Fragment() {
    private val myMainViewModel: PortfolioViewModel by viewModels()
    private lateinit var binding: FragmentCryptoOverviewBinding


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCryptoOverviewBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = myMainViewModel

        val args = arguments
        val crypto= args?.getParcelable<Crypto>(Constants.CRYPTO_KEY)!!
        binding.crypto = crypto


        val cryptoname : String = crypto!!.name.plus("(").plus(crypto!!.symbol).plus(")")
        binding.cryptoName.text = cryptoname

        val cryptoPrice : String = "$".plus(String.format("%.2f", crypto.priceUsd.toDouble()))
        binding.cryptoprice.text =cryptoPrice.toString()

        var imageURL1 = "https://static.coincap.io/assets/icons/"
        var imageURL2 = "@2x.png"
        var imageURL = imageURL1.plus(crypto.symbol.lowercase()).plus(imageURL2)

        binding.cryptoImageView.load(imageURL){
            crossfade(600)
        }

        binding.cryptoAmount.text=0.toString()
        binding.cryptoSymb.text = crypto.symbol
    }
}

