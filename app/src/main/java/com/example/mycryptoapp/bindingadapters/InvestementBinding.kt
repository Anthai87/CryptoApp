package com.example.mycryptoapp.bindingadapters

import android.widget.TextView
import androidx.databinding.BindingAdapter

class InvestementBinding {
    companion object {
        @BindingAdapter("amountToString")
        @JvmStatic
        fun amountToString(textView: TextView, amount: Double) {
            textView.text =
                amount.toString()
        }
        @BindingAdapter("cryptoInAmount")
        @JvmStatic
        fun cryptoInAmount(textView: TextView, cryptoPrice : String, amountofCrypto : String) {
            val amount : Double?
            val CryptoPrice : Double?
            CryptoPrice = cryptoPrice.toDouble()
            amount = amountofCrypto.toString().toDouble()
            val outAmout = amount * CryptoPrice
            textView.text =
                outAmout.toString()
        }
    }
}
