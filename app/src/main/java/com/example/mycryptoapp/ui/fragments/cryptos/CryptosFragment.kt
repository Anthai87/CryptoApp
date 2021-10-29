package com.example.mycryptoapp.ui.fragments.cryptos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycryptoapp.viewmodels.MainViewModel
import com.example.mycryptoapp.R
import com.example.mycryptoapp.adapters.CryptosAdapter
import com.example.mycryptoapp.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_cryptos.view.*

@AndroidEntryPoint
class CryptosFragment : Fragment() {

    private lateinit var mMainViewModel: MainViewModel
    private val mAdapter by lazy { CryptosAdapter() }
    private lateinit var mView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_cryptos, container, false)

        mMainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        setupRecyclerView()
        requestApiData()

        return mView
    }

    private fun setupRecyclerView() {
        mView.recyclerview.adapter = mAdapter
        mView.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        showShimmerEffect()
    }

    private fun showShimmerEffect() {
        mView.recyclerview.showShimmer()
    }

    private fun requestApiData() {
        mMainViewModel.getAssets()
        mMainViewModel.assetsResponse.observe(viewLifecycleOwner, { response ->
            when(response) {
                is NetworkResult.Success -> {
                    hideShimmerEffect()
                    response.data?.let { mAdapter.setData(it) }
                }
                is NetworkResult.Error -> {
                    hideShimmerEffect()
                    Toast.makeText(
                        requireContext(),
                        response.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is NetworkResult.Loading -> {
                    showShimmerEffect()
                }
            }
        })
    }

    private fun hideShimmerEffect() {
        mView.recyclerview.hideShimmer()
    }

}