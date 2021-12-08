package com.example.mycryptoapp.ui.fragments.cryptooverview

import android.database.sqlite.SQLiteDatabase.deleteDatabase
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.mycryptoapp.databinding.FragmentBuyCryptoBinding
import com.example.mycryptoapp.logic.PortfolioLogic
import com.example.mycryptoapp.logic.TransactionList
import com.example.mycryptoapp.models.*
import com.example.mycryptoapp.util.Constants
import com.example.mycryptoapp.util.Constants.Companion.PORTFOLIO_DATABASE_NAME
import com.example.mycryptoapp.viewmodels.PortfolioViewModel
import com.example.mycryptoapp.viewmodels.TransactionsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class InvestmentCryptoFragment : Fragment() {

    private lateinit var mTransactionsViewModel: TransactionsViewModel
    private lateinit var mPortfolioViewModel: PortfolioViewModel

    private val myMainViewModel: PortfolioViewModel by viewModels()
    private lateinit var binding: FragmentBuyCryptoBinding

    lateinit var crypto: Crypto
    var userInputUsdOrCrypto = 0.0

    var transactionList = TransactionList.list.transactions
    var investedCryptos = PortfolioLogic.portfolio.investedCryptos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mTransactionsViewModel = ViewModelProvider(requireActivity()).get(TransactionsViewModel::class.java)
        mPortfolioViewModel = ViewModelProvider(requireActivity()).get(PortfolioViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuyCryptoBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = myMainViewModel

        val args = arguments
        crypto = args?.getParcelable(Constants.CRYPTO_KEY)!!
        binding.crypto = crypto


        val cryptoname : String = crypto!!.name.plus("(").plus(crypto!!.symbol).plus(")")
        binding.buycryptoNAme.text = cryptoname

        val cryptoPrice : String = "$".plus(String.format("%.2f", crypto.priceUsd.toDouble()))
        binding.buycryptoprice.text =cryptoPrice.toString()

        binding.buycryptoSymbol.text=crypto.symbol.toString()

        var imageURL1 = "https://static.coincap.io/assets/icons/"
        var imageURL2 = "@2x.png"
        var imageURL = imageURL1.plus(crypto.symbol.lowercase()).plus(imageURL2)
        binding.cryptoImageView.load(imageURL){
            crossfade(600)
        }

        binding.canOnlyBuyUsd.text = "You have " + PortfolioLogic.portfolioAmount + " USD"

        //FUNCTION BINDING
        binding.buybutton.setOnClickListener{buyCrypto()}
        binding.sellbutton.setOnClickListener{sellCrypto()}
        binding.usdInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (count > 0)
                    if (s.toString().isDigitsOnly()) {
                        val usdAmount = PortfolioLogic.howMuchCryptoCouldBuy(s.toString().toDouble(), crypto.priceUsd.toDouble()).toString()
                        binding.amountOfCrypto.setText(usdAmount)
                        userInputUsdOrCrypto = s.toString().toDouble()
                    }
            }
        })
    }


    private fun buyCrypto() {// todo if empty should not being called
        if (userInputUsdOrCrypto <= PortfolioLogic.portfolioAmount) {
            binding.amountOfCrypto.setText("")
            binding.usdInput.setText("")

            PortfolioLogic.portfolioAmount -= userInputUsdOrCrypto

            // Store buy in transaction
            storeBuyInTransactions()

            // Store buy in portfolio
            storeBuyInPortfolio()

        } else {
            binding.amountOfCrypto.setText("")
            binding.usdInput.setText("")
            Toast.makeText(context, "You have only: " + PortfolioLogic.portfolioAmount, Toast.LENGTH_LONG).show()
        }
    }


    private fun storeBuyInTransactions() {
        val cryptoAmount = PortfolioLogic.howMuchCryptoCouldBuy(userInputUsdOrCrypto.toString().toDouble(), crypto.priceUsd.toDouble()).toString()
        val transaction = Transaction("BOUGHT",
            cryptoAmount+ " " + crypto.symbol + " for " + userInputUsdOrCrypto + " USD",
            crypto.symbol, System.currentTimeMillis().toInt())


        var transactions = transactionList.map { it } as MutableList<Transaction>
        transactions.add(transaction)
        transactions.sortBy { it.dateTime }
        insertTransactionsDatabase(transactions)

    }

    private fun insertTransactionsDatabase(transactions: MutableList<Transaction>) {
        mTransactionsViewModel.offlineCacheTransaction(Transactions(transactions))
    }

    private fun storeBuyInPortfolio() {
        // Store buy in portfolio
        val investedCrypto = InvestedCrypto(crypto, userInputUsdOrCrypto)
        var investedCryptos = investedCryptos.map { it } as MutableList<InvestedCrypto>
        investedCryptos.add(investedCrypto)

        var portfolio = Portfolio(investedCryptos, PortfolioLogic.portfolioAmount)
        insertPortfolioDatabase(portfolio)
    }

    private fun insertPortfolioDatabase(portfolio: Portfolio) {
        mPortfolioViewModel.offlineCachePortfolio(portfolio)
    }

    private fun sellCrypto() {
        Toast.makeText(context, "sell", Toast.LENGTH_SHORT).show()
    }

}


