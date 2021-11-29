package com.example.mycryptoapp.ui.fragments.cryptooverview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.mycryptoapp.R
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.util.Constants.Companion.CRYPTO_KEY
import kotlinx.android.synthetic.main.fragment_crypto_instructions.view.*


class CryptoInstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_crypto_instructions, container, false)

        val args = arguments
        val myBundle: Crypto? = args?.getParcelable(CRYPTO_KEY)

        view.instructions_webView.webViewClient = object : WebViewClient() {}
        val websiteUrl: String = myBundle!!.explorer
        view.instructions_webView.loadUrl(websiteUrl)

        return view;
    }

}