package xyz.devnote.techcrunchnews.manager.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class InterceptCallback<T> : Callback<T> {
    override fun onFailure(call: Call<T>, t: Throwable) {
        onFailure(t.message)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (!response.isSuccessful) {
            onFailure(response.message())
            return
        }

        onSuccess(response.body())
    }

    abstract fun onSuccess(result : T?)
    abstract fun onFailure(message : String?)
}