package com.example.mycryptoapp.util

import androidx.recyclerview.widget.DiffUtil
import com.example.mycryptoapp.models.Transactions


class TransactionsDiffUtil : DiffUtil.ItemCallback<Transactions>() {

    override fun areItemsTheSame(oldItem: Transactions, newItem: Transactions): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Transactions, newItem: Transactions): Boolean {
        return oldItem == newItem
    }

}








