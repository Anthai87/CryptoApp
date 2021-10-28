package com.example.mycryptoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Cartesian
import kotlinx.android.synthetic.main.fragment_crypto.*

class CryptoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_crypto, container, false)


        drawSinGraph();

        // Inflate the layout for this fragment
        return view




    }



    private fun drawSinGraph() {

        var series: ArrayList<DataEntry> = ArrayList()

        //Step 1
        //Create a series of your data points for x and y axis
        for ( angle in 0..360 ) {

            var radian = Math.toRadians( angle.toDouble())
            series.add( ValueDataEntry( /* x-axis */ angle , /* y-axis */ Math.sin(radian) ) )
        }

        // Step 2 assign series to AnyChart column (Data Structure of library)
        val cartesian: Cartesian = AnyChart.column()
        cartesian.column(series) // set your

        // Step 3 assign column to chartview

        chartView.setChart(cartesian)
    }

}