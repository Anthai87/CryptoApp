package com.example.mycryptoapp.ui.fragments.favorites

import android.animation.ValueAnimator
import android.graphics.DashPathEffect
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mycryptoapp.R
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.models.CryptoAsset
import com.example.mycryptoapp.models.CryptoHistoricalData
import com.example.mycryptoapp.util.Constants.Companion.ALL
import com.example.mycryptoapp.util.Constants.Companion.HOUR
import kotlinx.android.synthetic.main.historical_chart_module.*
import kotlinx.android.synthetic.main.historical_chart_module.view.*
import java.util.*


private const val TAG = "FavoriteCryptosFragment"

class FavoriteCryptosFragment : Fragment() {

    private var historicalData: List<Crypto>? = null
    private var coinPrice: Crypto? = null
    private var selectedHour = HOUR


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


    /* fun setChartData(historicalChartModuleData: HistoricalChartModuleData) {
         this.coinPrice = historicalChartModuleData.coinPrice
         animateCoinPrice(historicalChartModuleData.coinPrice?.priceUsd)

         if (historicalChartModuleData.historicalDataPair == null) {
             showOrHideChartLoadingIndicator(true)
         } else {
             showOrHideChartLoadingIndicator(false)

             historicalData = historicalChartModuleData.historicalDataPair.first

             setupChart(historicalChartModuleData.historicalDataPair)
             if (historicalChartModuleData.period != ALL) {
                // showPercentageGainOrLoss(historicalChartModuleData.historicalDataPair.first)
             } else {
                 tvPortfolioChangedValue.text = ""
                 //showPositiveGainColor()
             }
             //showChartPeriodText(historicalChartModuleData.period)

             addChartScrubListener()
             addRangeSelectorListener(historicalChartModuleData.fromCurrency)

         }
         historicalChartModuleData.historicalDataPair


     }

     private fun animateCoinPrice(amount: String?) {
         if (amount != null) {
             val chartCoinPriceAnimation =
                 ValueAnimator.ofFloat(tvChartCoinPrice.tag.toString().toFloat(), amount.toFloat())
             chartCoinPriceAnimation.duration = chartAnimationDuration
             chartCoinPriceAnimation.addUpdateListener { updatedAnimation ->
                 val animatedValue = updatedAnimation.animatedValue as Float
                 tvChartCoinPrice.text =
                     formatter.formatAmount(animatedValue.toString(), currency)
                 tvChartCoinPrice.tag = animatedValue
             }
             chartCoinPriceAnimation.start()
         }
     }


     private fun setupChart(dailyDataListPair: Pair<List<CryptoAsset>, CryptoAsset?>) {
         historicalChartView.adapter =
             CryptoSparkAdapter(dailyDataListPair.first, dailyDataListPair.second?.crypto?.priceUsd)


         val baseLinePaint = historicalChartView.baseLinePaint
         val dashPathEffect = DashPathEffect(floatArrayOf(10.0f, 2.0f), 0f)
         baseLinePaint.pathEffect = dashPathEffect

     }

     private fun updateInforFordate(cryptoData: Crypto) {


     }

     interface OnHistoricalChardRangeSelectionListener {
         fun onRangeSelected(period: String, fromCurrency: String, toCurrency: String)
     }

     private fun showOrHideChartLoadingIndicator(showLoading: Boolean) {
         tvErrorGraph.visibility = View.GONE
         if (showLoading) pbChartLoading.show() else pbChartLoading.hide()
     }
     private fun addChartScrubListener() {
         historicalChartView.setScrubListener { value ->
             if (value == null) { // reset the quantity
                 animateCoinPrice(coinPrice?.priceUsd)
                // showPercentageGainOrLoss(historicalData)
                 //showChartPeriodText(selectedPeriod)
             } else {
                 val historicalData = value as Crypto
                 tvPortfolioChangedValue.visibility = View.GONE
                // tvPortfolioChangedDate.text = formatter.formatDate(historicalData.time, 1000)
                 //animateCoinPrice(historicalData.close)
             }
         }
     }

     data class HistoricalChartModuleData(
         val coinPrice: Crypto?,
         val period: String,
         val fromCurrency: String,
         val historicalDataPair: Pair<List<CryptoAsset>, CryptoAsset?>?
     ) : ModuleItem*/

}


