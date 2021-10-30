package com.example.mycryptoapp.ui.fragments.cryptos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycryptoapp.viewmodels.MainViewModel
import com.example.mycryptoapp.R
import com.example.mycryptoapp.adapters.CryptosAdapter
import com.example.mycryptoapp.databinding.FragmentCryptosBinding
import com.example.mycryptoapp.util.NetworkResult
import com.example.mycryptoapp.util.observeOnce
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_cryptos.view.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CryptosFragment : Fragment() {

    private var _binding: FragmentCryptosBinding? = null
    private val binding get() = _binding!!

    private lateinit var mMainViewModel: MainViewModel
    private val mAdapter by lazy { CryptosAdapter() }
    private lateinit var mView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCryptosBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.mainViewModel = mMainViewModel

        setupRecyclerView()
        readDatabase()

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.recyclerview.adapter = mAdapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        showShimmerEffect()
    }

    // Todo: load data from api every 5 seconds just between opening and closing market place(Schedule a worker)
    private fun readDatabase() {
        lifecycleScope.launch {
            mMainViewModel.readAssets.observeOnce(viewLifecycleOwner, {database ->
                if (database.isNotEmpty()) {
                    Log.d("RecipesFragment", "readDatabase called!")
                    mAdapter.setData(database[0].assets)
                    hideShimmerEffect()
                } else {
                    requestApiData()
                }
            })
        }
    }

    private fun requestApiData() {
        Log.d("RecipesFragment", "readApiData called!")
        mMainViewModel.getAssets()
        mMainViewModel.assetsResponse.observe(viewLifecycleOwner, { response ->
            when(response) {
                is NetworkResult.Success -> {
                    hideShimmerEffect()
                    response.data?.let { mAdapter.setData(it) }
                }
                is NetworkResult.Error -> {
                    hideShimmerEffect()
                    loadDataFromCache()
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

    private fun loadDataFromCache() {
        lifecycleScope.launch {
            mMainViewModel.readAssets.observe(viewLifecycleOwner, { database ->
                if (database.isNotEmpty()) {
                    mAdapter.setData(database[0].assets)
                }
            })
        }
    }
    private fun showShimmerEffect() {
        binding.recyclerview.showShimmer()
    }

    private fun hideShimmerEffect() {
        binding.recyclerview.hideShimmer()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}