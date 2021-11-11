package com.example.mycryptoapp.util

import androidx.recyclerview.widget.DiffUtil
import com.example.mycryptoapp.models.Crypto

class CryptosDiffUtil: DiffUtil.ItemCallback<Crypto>() {

    override fun areItemsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
        return oldItem == newItem
    }

}