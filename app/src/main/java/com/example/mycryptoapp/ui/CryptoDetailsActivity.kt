package com.example.mycryptoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.navArgs
import com.example.mycryptoapp.R
import com.example.mycryptoapp.databinding.ActivityCryptoDetailsBinding
import com.example.mycryptoapp.ui.fragments.cryptoadvice.PagerAdapter
import com.example.mycryptoapp.ui.fragments.cryptooverview.CryptoInstructionsFragment
import com.example.mycryptoapp.ui.fragments.cryptooverview.CryptoOverviewFragment
import com.example.mycryptoapp.ui.fragments.cryptooverview.InvestmentCryptoFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptoDetailsActivity : AppCompatActivity() {

    private val args by navArgs<CryptoDetailsActivityArgs>()
    private lateinit var binding: ActivityCryptoDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityCryptoDetailsBinding>(
            this,
            R.layout.activity_crypto_details
        )

        setSupportActionBar(binding.toolbar)
        binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val fragments = ArrayList<Fragment>()
        fragments.add(CryptoOverviewFragment())
        fragments.add(InvestmentCryptoFragment())
        fragments.add(CryptoInstructionsFragment())

        val titles = ArrayList<String>()
        titles.add("OVERVIEW")
        titles.add("INVESTMENT")
        titles.add("INSTRUCTIONS")

        val resultBundle = Bundle()
        resultBundle.putParcelable("cryptoBundle", args.crypto)

        val adapter = PagerAdapter(
            resultBundle,
            fragments,
            titles,
            supportFragmentManager
        )

        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}