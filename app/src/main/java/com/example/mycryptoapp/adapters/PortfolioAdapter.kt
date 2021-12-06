package com.example.mycryptoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycryptoapp.R
import com.example.mycryptoapp.logic.PortfolioLogic
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.models.InvestedCrypto
import com.example.mycryptoapp.models.Transaction
import kotlinx.android.synthetic.main.cryptos_row_portfolio_layout.view.*
import coil.load

class PortfolioAdapter(var list: List<InvestedCrypto>): RecyclerView.Adapter<PortfolioAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cryptos_row_portfolio_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.cryptoAmount.text = PortfolioLogic.howMuchMoneyCouldGetWhenSell(list.get(i).amount, list.get(i).crypto.priceUsd.toDouble()).toString()
        viewHolder.priceUSD.text = list.get(i).amount.toString()

        var imageURL1 = "https://static.coincap.io/assets/icons/"
        var imageURL2 = "@2x.png"
        var imageURL = imageURL1.plus(list.get(i).crypto.symbol.lowercase()).plus(imageURL2)
        viewHolder.cryptoImageView.load(imageURL){
            crossfade(600)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(investedCryptos: List<InvestedCrypto>) {
        list = investedCryptos
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cryptoAmount: TextView = itemView.crypto_amount_textView
        var priceUSD: TextView = itemView.price_usd_textView
        var cryptoImageView: ImageView = itemView.cryptoImageView
    }
}