package com.example.mycryptoapp.ui.fragments.transactions

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycryptoapp.R
import com.example.mycryptoapp.adapters.TransactionsAdapter
import com.example.mycryptoapp.logic.TransactionList
import com.example.mycryptoapp.models.Transaction
import com.example.mycryptoapp.models.Transactions
import com.example.mycryptoapp.util.observeOnce
import com.example.mycryptoapp.viewmodels.TransactionsViewModel
import kotlinx.android.synthetic.main.fragment_transactions.view.*
import kotlinx.coroutines.launch


class TransactionsFragment : Fragment() {

    private lateinit var mTransactionsViewModel: TransactionsViewModel

    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var adapter: TransactionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mTransactionsViewModel =
            ViewModelProvider(requireActivity()).get(TransactionsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_transactions, container, false)

        layoutManager = LinearLayoutManager(activity)
        adapter = TransactionsAdapter(listOf())

        view.transaction_recycler_view.layoutManager = layoutManager
        view.transaction_recycler_view.setHasFixedSize(true)
        view.transaction_recycler_view.adapter = adapter

        readDatabase()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readDatabase()
    }


    private fun readDatabase() {
        lifecycleScope.launch {
            mTransactionsViewModel.readTransactions.observeOnce(viewLifecycleOwner) { database ->
                if (database.isNotEmpty()) {
                    Log.d("CryptosFragment", "readDatabase called!")
                    adapter.setData(database[0].transactions.transactions)
                    TransactionList.list = database[0].transactions
                } else {
                    Log.d("CryptosFragment", "readDatabase called!")
                }
            }
        }
    }


}