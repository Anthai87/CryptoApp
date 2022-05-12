package com.example.mycryptoapp.data.network

import com.example.mycryptoapp.models.Assets
import com.example.mycryptoapp.models.Crypto
import com.example.mycryptoapp.models.CryptoAsset
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoAssetsApi {

    @GET("v2/assets")
    suspend fun getAssets(): Response<Assets>

    @GET("v2/assets/{cryptoName}")
    suspend fun searchCrypto(
        @Path("cryptoName") searchPath: String
    ): Response<CryptoAsset>

}


/* One of the key aspects of creating a high quality android app is to keep the user
* interface responsive. When we are doing an expensive operation, like an API call or networking
* we need to use concurrency to punt, the expensive work to another thread which is not handling the UI
* when our app is making a call to some external service over the internet, that networking operation
* could take an arbitrarily long amount of time or it could fail.
* while the networking operation is happening, our Android App should continue to receive input
* and process events. So now the question is how can we gracefully handle this problem of our app,
* doing multiple things at once. This is concurrent or asynchronous programming, and it is a fairly hard computer
* science problem. The kotlin approach here is to use coroutines.
* How is the android app architected?
* Android apps run as a single process on your phones operating system.
* A process can contain many threads. It will have one special thread called the main thread. And then it can also have
* many background threads. By default, your application code will run on the main thread. Also called the UI thread because that is
* where the android system will draw you apps UI 60 times per second. It is very important that any of the code you write doesnt interfere with
* the android systems abiltiy to draw your app at the target refresh rate of 60 times per second. That is why network calls to an API reading a file
* from a database and other expensive operations are done in a background thread. This is called asynchronous programming to indicate that
* this work is not happening synchronously on the main thread. And instead the work is being punted to a background thread so we can avoid blocking
* the main thread and avoid something called Genke. Instead of using callback kotlin has a really nice way of handling this type of */
