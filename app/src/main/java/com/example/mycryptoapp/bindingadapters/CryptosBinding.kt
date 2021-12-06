package com.example.mycryptoapp.bindingadapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.mycryptoapp.data.database.assets.AssetsEntity
import com.example.mycryptoapp.models.Assets
import com.example.mycryptoapp.util.NetworkResult

class CryptosBinding {

    companion object {

        @BindingAdapter("readApiResponse1", "readDatabase1", requireAll = false)
        @JvmStatic
        fun errorImageViewVisibility(
            imageView: ImageView,
            apiResponse: NetworkResult<Assets>?,
            database: List<AssetsEntity>?
        ) {
            if (apiResponse is NetworkResult.Error && database.isNullOrEmpty()) {
                imageView.visibility = View.VISIBLE
            } else if (apiResponse is NetworkResult.Loading) {
                imageView.visibility = View.INVISIBLE
            } else if (apiResponse is NetworkResult.Success) {
                imageView.visibility = View.INVISIBLE
            }
        }

        @BindingAdapter("readApiResponse2", "readDatabase2", requireAll = false)
        @JvmStatic
        fun errorTextViewVisibility(
            textView: TextView,
            apiResponse: NetworkResult<Assets>?,
            database: List<AssetsEntity>?
        ) {
            if (apiResponse is NetworkResult.Error && database.isNullOrEmpty()) {
                textView.visibility = View.VISIBLE
                textView.text = apiResponse.message.toString()
            } else if (apiResponse is NetworkResult.Loading) {
                textView.visibility = View.INVISIBLE
            } else if (apiResponse is NetworkResult.Success) {
                textView.visibility = View.INVISIBLE
            }
        }


        @BindingAdapter("reformatTimestamp")
        @JvmStatic
        fun reformatTimestamp(textView: TextView, timestamp: Long) {
            textView.text = timestamp.toString()
        }


    }
}