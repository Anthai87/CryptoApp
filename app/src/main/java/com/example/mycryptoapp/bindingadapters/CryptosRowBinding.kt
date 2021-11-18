package com.example.mycryptoapp.bindingadapters

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.example.mycryptoapp.R
import coil.load
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.ui.fragments.cryptos.CryptosFragmentDirections
import java.lang.Exception

class CryptosRowBinding {

    companion object {

        @BindingAdapter("onCryptoClickListener")
        @JvmStatic
        fun onCryptoClickListener(cryptoRowLayout: ConstraintLayout, crypto: Crypto) {
            Log.d("onCryptoClickListener", crypto.toString())
            cryptoRowLayout.setOnClickListener {
                try {
                    val action =
                        CryptosFragmentDirections.actionCryptosFragmentToCryptoDetailsActivity(
                            crypto
                        )
                    cryptoRowLayout.findNavController().navigate(action)
                } catch (e: Exception) {
                    Log.d("onCryptoClickListener", e.toString())
                }
            }
        }

        @BindingAdapter("reformatCryptoSymbol")
        @JvmStatic
        fun reformatCryptoSymbol(textView: TextView, cryptoSymbol: String) {
            textView.text = when (cryptoSymbol.trim().length) {
                1 -> "$cryptoSymbol       "
                2 -> "$cryptoSymbol      "
                3 -> "$cryptoSymbol     "
                4 -> "$cryptoSymbol    "
                5 -> "$cryptoSymbol   "
                6 -> "$cryptoSymbol  "
                7 -> "$cryptoSymbol "
                else -> "$cryptoSymbol"
            }
        }

        @BindingAdapter("reformatPriceUsd")
        @JvmStatic
        fun reformatPriceUsd(textView: TextView, priceUsd: String) {
            textView.text = addDollarSymbol(setTwoDecimalToPrice(priceUsd))
        }

        private fun setTwoDecimalToPrice(price: String): String {
            return String.format("%.2f", price.toDouble())
        }

        private fun addDollarSymbol(price: String): String {
            return "$$price"
        }

        @BindingAdapter("reformatChangePercent24Hr")
        @JvmStatic
        fun reformatChangePercent24Hr(textView: TextView, changePercent24Hr: String) {
            setColor(textView, changePercent24Hr)
            textView.text =
                addPercentSign(addPlusOrMinusSign(setTwoDecimalToPercent(changePercent24Hr)))
        }

        @BindingAdapter("loadImageFromURL")
        @JvmStatic
        fun loadImageFromURL(imageView: ImageView, currencyName: String) {

            var imageURL1 = "https://static.coincap.io/assets/icons/"
            var imageURL2 = "@2x.png"
            var imageURL = imageURL1.plus(currencyName.toLowerCase()).plus(imageURL2)
            imageView.load(imageURL) {
                crossfade(600)
            }
        }

        private fun setColor(textView: TextView, changePercent24Hr: String) {
            return if (changePercent24Hr.toDouble() > 0)
                textView.setTextColor(
                    ContextCompat.getColor(
                        textView.context,
                        R.color.green
                    )
                )
            else
                textView.setTextColor(
                    ContextCompat.getColor(
                        textView.context,
                        R.color.red
                    )
                )
        }

        private fun setTwoDecimalToPercent(percent: String): String {
            return String.format("%.2f", percent.toDouble())
        }

        private fun addPlusOrMinusSign(percent: String): String {
            return if (percent.toDouble() > 0) "+$percent" else "$percent"
        }

        private fun addPercentSign(addPlusOrMinusSign: String): String {
            return "$addPlusOrMinusSign%"
        }

    }

}