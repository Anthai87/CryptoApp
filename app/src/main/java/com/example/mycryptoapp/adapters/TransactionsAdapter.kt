package com.example.mycryptoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycryptoapp.R
import com.example.mycryptoapp.models.Transaction
import kotlinx.android.synthetic.main.transactions_row_layout.view.*

class TransactionsAdapter(var list: List<Transaction>) :
    RecyclerView.Adapter<TransactionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.transactions_row_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.title.text = list.get(i).title
        viewHolder.description.text = list.get(i).description
        viewHolder.dateTime.text = list.get(i).dateTime.toString()

        //viewHolder.cryptoImage.imageView.setImageResource(R.drawable.btc)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(transactions: List<Transaction>) {
        list = transactions
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.soldOrBoughtCrypto
        var description: TextView = itemView.transaction_description
        var dateTime: TextView = itemView.dateTime
        var cryptoImage: ImageView = itemView.transaction_recycler_view_image
    }
}









