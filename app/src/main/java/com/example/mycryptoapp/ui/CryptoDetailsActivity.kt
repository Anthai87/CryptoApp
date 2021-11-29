package com.example.mycryptoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.navArgs
import com.example.mycryptoapp.R
import com.example.mycryptoapp.ui.fragments.cryptoadvice.PagerAdapter
import com.example.mycryptoapp.ui.fragments.overview.CryptoOverviewFragment
import com.example.mycryptoapp.ui.fragments.overview.CryptoTransactionsFragment
import kotlinx.android.synthetic.main.activity_crypto_details.*

class CryptoDetailsActivity : AppCompatActivity() {

    private val args by navArgs<CryptoDetailsActivityArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crypto_details)

        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val fragments = ArrayList<Fragment>()
        fragments.add(CryptoOverviewFragment())
        fragments.add(CryptoTransactionsFragment())

        val titles = ArrayList<String>()
        titles.add("OVERVIEW")
        titles.add("INSTRUCTIONS")

        val resultBundle = Bundle()
        resultBundle.putParcelable("cryptoBundle", args.crypto)

        val adapter = PagerAdapter(
            resultBundle,
            fragments,
            titles,
            supportFragmentManager
        )

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }

    // Todo: bug when click on even row then go back to it
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}