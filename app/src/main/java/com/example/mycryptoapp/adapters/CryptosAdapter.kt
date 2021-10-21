package com.example.mycryptoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mycryptoapp.databinding.CryptosRowLayoutBinding
import com.example.mycryptoapp.models.Assets
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.util.CryptosDiffUtil

class CryptosAdapter: RecyclerView.Adapter<CryptosAdapter.MyViewHolder>() {

    private var cryptos = emptyList<Crypto>()

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
                val binding = CryptosRowLayoutBinding.inflate(layoutInflater)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentCrypto = cryptos[position]
        holder.bind(currentCrypto)
    }

    override fun getItemCount(): Int {
        return cryptos.size
    }

    fun setData(assets: Assets) {
        val cryptosDiffUtil = CryptosDiffUtil(cryptos, assets.cryptos)
        val diffUtilResult = DiffUtil.calculateDiff(cryptosDiffUtil)
        cryptos = assets.cryptos
        diffUtilResult.dispatchUpdatesTo(this)
    }
}