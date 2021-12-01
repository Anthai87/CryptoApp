package com.example.mycryptoapp.bindingadapters

import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.models.Transactions
import com.example.mycryptoapp.ui.fragments.cryptos.CryptosFragmentDirections
import com.example.mycryptoapp.ui.fragments.favorites.FavoriteCryptosFragment
import java.lang.Exception

class TransactionsRowBinding {

    companion object{
        @BindingAdapter("onTransactionClickListener")
        @JvmStatic
        fun onTransactionClickListener(transactionRowLayout: ConstraintLayout, transactions: Transactions){
            Log.d("onTransactionClickListener", transactions.toString())



        }
    }
}
