package com.example.mycryptoapp.ui.fragments.favorites

import android.graphics.DashPathEffect
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

    // private lateinit var adapter: CryptoSparkAdapter
    // private lateinit var currentlyShownData: List<Crypto>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.historical_chart_module, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


   // fun setChartData()


    private fun setupChart(dailyDataListPair: Pair<List<Crypto>, Crypto?>) {
        historicalChartView.adapter = CryptoSparkAdapter(dailyDataListPair.first, dailyDataListPair.second?.priceUsd)


        // updateInforFordate(dailyData.last())

        val baseLinePaint = historicalChartView.baseLinePaint
        val dashPathEffect = DashPathEffect(floatArrayOf(10.0f, 2.0f), 0f)
        baseLinePaint.pathEffect = dashPathEffect

    }

    private fun updateInforFordate(cryptoData: Crypto) {


    }

}


