package com.example.mycryptoapp.ui.fragments.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.ContentLoadingProgressBar
import com.example.mycryptoapp.R
import com.example.mycryptoapp.models.Assets
import com.example.mycryptoapp.models.Crypto
import com.robinhood.spark.SparkView
import kotlinx.android.synthetic.main.historical_chart_module.*


class FavoriteCryptosFragment : Fragment() {
    private lateinit var adapter: CryptoSparkAdapter
    private lateinit var currentlyShownData: List<Crypto>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.historical_chart_module, container, false)
    }

    private fun updateDisplayWithData(dailyData: List<Crypto>) {

        val adapter = CryptoSparkAdapter(dailyData)
        historicalChartView.adapter = adapter



        // updateInforFordate(dailyData.last())

    }
    private fun updateInforFordate(cryptoData: Crypto) {


    }
}


