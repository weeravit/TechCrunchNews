package xyz.devnote.techcrunchnews.manager

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.devnote.techcrunchnews.common.Constants
import xyz.devnote.techcrunchnews.modules.news.model.NewsRequest
import xyz.devnote.techcrunchnews.modules.news.model.NewsResponse


class HttpManager {

    private val service by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(APIService::class.java)
    }

    fun getNews(request : NewsRequest,
                callback : (response : NewsResponse?) -> Unit) {
        service.getNews(request.page!!)
            .enqueue(object : Callback<NewsResponse> {
                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {

                }

                override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                    callback.invoke(response.body())
                }
            })
    }

    companion object {
        private val instance = HttpManager()

        fun getInstance() = instance
    }
}