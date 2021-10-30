package com.example.mycryptoapp.ui.fragments.cryptos

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycryptoapp.viewmodels.MainViewModel
import com.example.mycryptoapp.R
import com.example.mycryptoapp.adapters.CryptosAdapter
import com.example.mycryptoapp.databinding.FragmentCryptosBinding
import com.example.mycryptoapp.models.Assets
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.util.NetworkResult
import com.example.mycryptoapp.util.observeOnce
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class CryptosFragment : Fragment(), SearchView.OnQueryTextListener {

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

        setHasOptionsMenu(true)

        setupRecyclerView()
        readDatabase()

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.recyclerview.adapter = mAdapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        showShimmerEffect()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.cryptos_menu, menu)

        val search = menu.findItem(R.id.menu_search)
        val searchView = search.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(searchPath: String?): Boolean {
        if (searchPath != null) {
            searchApiData(searchPath.lowercase(Locale.getDefault()))
        }
        return true
    }

    override fun onQueryTextChange(searchPath: String?): Boolean {
        if (searchPath != null) {
            readDatabase()
        }
        return true
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

    private fun searchApiData(searchPath: String) {
        showShimmerEffect()
        mMainViewModel.searchCrypto(searchPath)
        mMainViewModel.searchCryptoResponse.observe(viewLifecycleOwner, { response ->
            when (response) {
                is NetworkResult.Success -> {
                    hideShimmerEffect()
                    val assetsCrypto = response.data
                    val assets = assetsCrypto?.let { Assets(listOf(it.crypto), it.timestamp) }
                    assets?.let { mAdapter.setData(it) }
                }
                is NetworkResult.Error -> {
                    hideShimmerEffect()
                    loadDataFromCache()
                    Toast.makeText(
                        requireContext(),
                        response.message.toString(),
                        Toast.LENGTH_SHORT
                    )
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