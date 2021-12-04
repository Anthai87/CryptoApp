package com.example.mycryptoapp.bindingadapters

import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.example.mycryptoapp.models.Transactions

class TransactionsRowBinding {

    companion object{
        @BindingAdapter("onTransactionClickListener")
        @JvmStatic
        fun onTransactionClickListener(transactionRowLayout: ConstraintLayout, transactions: Transactions){
            Log.d("onTransactionClickListener", transactions.toString())



        }
    }
}
