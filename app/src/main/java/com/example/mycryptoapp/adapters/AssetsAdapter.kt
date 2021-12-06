//package com.example.mycryptoapp.adapters
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.AsyncDifferConfig
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.mycryptoapp.bindingadapters.CryptosBinding
//import com.example.mycryptoapp.databinding.CryptosRowLayoutBinding
//import com.example.mycryptoapp.models.Assets
//import com.example.mycryptoapp.models.Crypto
//import com.example.mycryptoapp.util.CryptosDiffUtil
//
//class AssetsAdapter(config: AsyncDifferConfig<Assets>) :
//    ListAdapter<Assets, AssetsAdapter.MyViewHolder>(config) {
//
//
//    class MyViewHolder(
//        private val binding: CryptosBinding
//    ): RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(assets: Assets) {
//            binding.assets = assets
//            binding.executePendingBindings()
//        }
//
//        companion object {
//            fun from(parent: ViewGroup): MyViewHolder {
//                val  layoutInflater = LayoutInflater.from(parent.context)
//                val binding = CryptosBinding.inflate(layoutInflater, parent, false)
//                return MyViewHolder(binding)
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetsAdapter.MyViewHolder {
//        return AssetsAdapter.MyViewHolder.from(parent)
//    }
//
//    override fun onBindViewHolder(holder: AssetsAdapter.MyViewHolder, position: Int) {
//        val currentCrypto = getItem(position)
//        holder.bind(currentCrypto)
//    }
//}
