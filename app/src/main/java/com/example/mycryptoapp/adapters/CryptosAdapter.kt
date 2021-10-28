package com.example.mycryptoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mycryptoapp.databinding.CryptosRowLayoutBinding
import com.example.mycryptoapp.models.Assets
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.util.CryptosDiffUtil

class CryptosAdapter: ListAdapter<Crypto, CryptosAdapter.MyViewHolder>(CryptosDiffUtil()) {

    class MyViewHolder(
        private val binding: CryptosRowLayoutBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(crypto: Crypto) {
            binding.crypto = crypto
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val  layoutInflater = LayoutInflater.from(parent.context)
                val binding = CryptosRowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentCrypto = getItem(position)
        holder.bind(currentCrypto)
    }

    fun setData(assets: Assets) {
        submitList(assets.cryptos)
    }

}