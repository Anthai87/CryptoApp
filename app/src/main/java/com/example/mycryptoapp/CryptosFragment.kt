package com.example.mycryptoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Cartesian
import com.anychart.charts.Pie
import com.anychart.core.cartesian.series.Bar
import kotlinx.android.synthetic.main.fragment_crypto.*
import kotlinx.android.synthetic.main.fragment_cryptos.*
import kotlinx.android.synthetic.main.fragment_cryptos.view.*
import retrofit2.Call
import retrofit2.Response
import java.util.ArrayList
import javax.security.auth.callback.Callback


class CryptosFragment : Fragment() {
    private val salary = listOf(200, 300, 400, 600, 700, 10000)
    private val month = listOf("Januar", "Februar", "Marts", "April", "May", "June")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_cryptos, container, false)

        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getAssets()

        call.enqueue(object : Callback<MutableList<PostModel>>{

        })

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        drawSinGraph()

    }


    private fun drawSinGraph() {
        val pie: Pie = AnyChart.pie()
        val dataPieChart: MutableList<DataEntry> = mutableListOf()

        for (index in salary.indices) {
            dataPieChart.add(ValueDataEntry(month.elementAt(index), salary.elementAt(index)))
        }

        pie.data(dataPieChart)
        //pie.title("Salaries Overview")
        chartView1.setChart(pie)

    }

}


