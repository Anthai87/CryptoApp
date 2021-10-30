package com.example.mycryptoapp.viewmodels

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.*
import com.example.mycryptoapp.data.Repository
import com.example.mycryptoapp.data.database.AssetsEntity
import com.example.mycryptoapp.models.Assets
import com.example.mycryptoapp.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import retrofit2.Response

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    application: Application
) : AndroidViewModel(application) {

    /** ROOM DATABASE */
    val readAssets: LiveData<List<AssetsEntity>> = repository.local.readDatabase().asLiveData()

    /** RETROFIT */
    var assetsResponse: MutableLiveData<NetworkResult<Assets>> = MutableLiveData()

    fun getAssets() = viewModelScope.launch {
        getAssetsSafeCall()
    }

    private suspend fun getAssetsSafeCall() {
        assetsResponse.value = NetworkResult.Loading()
        if (hasInternetConnection()) {
            try {
                val response = repository.remote.getAssets()
                assetsResponse.value = handleCryptoAssetsResponse(response)

                val assets = assetsResponse.value!!.data
                if (assets != null) {
                    offlineCacheAssets(assets)
                }
            } catch (e: Exception) {
                assetsResponse.value = NetworkResult.Error("Assets not found.")
            }
        } else {
            assetsResponse.value = NetworkResult.Error("No Internet Connection.")
        }
    }

    private fun offlineCacheAssets(assets: Assets) {
        val assetsEntity = AssetsEntity(assets)
        insertAssets(assetsEntity)
    }

    private fun insertAssets(assetsEntity: AssetsEntity) =
        /** ROOM DATABASE */
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.insertAssets(assetsEntity)
        }

    private fun handleCryptoAssetsResponse(response: Response<Assets>): NetworkResult<Assets>? {
        when {
            response.message().toString().contains("timeout") -> {
                return NetworkResult.Error("Timeout")
            }
            response.code() == 402 -> {
                return NetworkResult.Error("API Key Limited.")
            }
            response.body()!!.cryptos.isNullOrEmpty() -> {
                return NetworkResult.Error("API Key Limited.")
            }
            response.isSuccessful -> {
                val cryptoAssets = response.body()
                return NetworkResult.Success(cryptoAssets!!)
            }
            else -> {
                return NetworkResult.Error(response.message())
            }
        }
    }

    private fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<Application>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager

        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

}