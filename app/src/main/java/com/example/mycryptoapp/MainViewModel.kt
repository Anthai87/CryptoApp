package com.example.mycryptoapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycryptoapp.data.Repository
import com.example.mycryptoapp.models.Assets
import com.example.mycryptoapp.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    // Todo: Handle network and response error later

    var assetsResponse: MutableLiveData<NetworkResult<Assets>> = MutableLiveData()

    fun getAssets(queries: Map<String, String>) = viewModelScope.launch {
        val response = repository.remote.getAssets(queries)
        val assets = response.body()
        assetsResponse.value = NetworkResult.Success(assets!!)
    }

}