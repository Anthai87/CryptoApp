package com.example.mycryptoapp.bindingadapters

import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.mycryptoapp.R

class CryptosRowBinding {

    companion object {

        @BindingAdapter("reformatCryptoSymbol")
        @JvmStatic
        fun reformatCryptoSymbol(textView: TextView, cryptoSymbol: String) {
            textView.text = when(cryptoSymbol.trim().length) {
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
            textView.text = addPercentSign(addPlusOrMinusSign(setTwoDecimalToPercent(changePercent24Hr)))
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