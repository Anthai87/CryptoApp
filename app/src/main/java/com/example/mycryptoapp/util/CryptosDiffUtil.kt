package com.example.mycryptoapp.util

import androidx.recyclerview.widget.DiffUtil
import com.example.mycryptoapp.models.Crypto

class CryptosDiffUtil(
    private val oldList: List<Crypto>,
    private val newList: List<Crypto>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}