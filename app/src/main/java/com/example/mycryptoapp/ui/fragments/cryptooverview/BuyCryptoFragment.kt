package com.example.mycryptoapp.ui.fragments.cryptooverview

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.example.mycryptoapp.R
import com.example.mycryptoapp.databinding.FragmentBuyCryptoBinding
import com.example.mycryptoapp.logic.PortfolioLogic
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.util.Constants
import com.example.mycryptoapp.viewmodels.PortfolioViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_buy_crypto.*
import java.util.*


@AndroidEntryPoint
class BuyCryptoFragment : Fragment() {
    private val myMainViewModel: PortfolioViewModel by viewModels()
    private lateinit var binding: FragmentBuyCryptoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuyCryptoBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = myMainViewModel

        val args = arguments
        val crypto= args?.getParcelable<Crypto>(Constants.CRYPTO_KEY)!!
        binding.crypto = crypto


        val cryptoname : String = crypto!!.name.plus("(").plus(crypto!!.symbol).plus(")")
        binding.buycryptoNAme.text = cryptoname

        val cryptoPrice : String = "$".plus(String.format("%.2f", crypto.priceUsd.toDouble()))
        binding.buycryptoprice.text =cryptoPrice.toString()

        binding.buycryptoSymbol.text=crypto.symbol.toString()

        var imageURL1 = "https://static.coincap.io/assets/icons/"
        var imageURL2 = "@2x.png"
        var imageURL = imageURL1.plus(crypto.symbol.lowercase()).plus(imageURL2)
        binding.cryptoImageView.load(imageURL){
            crossfade(600)
        }

        binding.canOnlyBuyUsd.text = "You have " + PortfolioLogic.portfolioAmount + " USD"

        //FUNCTION BINDING
        binding.buybutton.setOnClickListener{buyCrypto()}
        binding.sellbutton.setOnClickListener{sellCrypto()}
        binding.usdInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (count > 0)
                    if (s.toString().isDigitsOnly())
                        binding.amountOfCrypto.setText(PortfolioLogic.howMuchCryptoCouldBuy(s.toString().toDouble(), crypto.priceUsd.toDouble()).toString())
            }
        })
    }


    private fun buyCrypto() {

        Toast.makeText(context, "Hello Javatpoint", Toast.LENGTH_LONG).show()
    }


    private fun sellCrypto() {
        Toast.makeText(context, "sell", Toast.LENGTH_SHORT).show()
    }


}


