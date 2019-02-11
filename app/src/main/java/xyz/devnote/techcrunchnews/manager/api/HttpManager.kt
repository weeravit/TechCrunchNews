package xyz.devnote.techcrunchnews.manager.api

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

    fun getNews(request: NewsRequest, callback: InterceptCallback<NewsResponse>) {
        service.getNews(request.page!!).enqueue(callback)
    }

    companion object {
        private val instance = HttpManager()

        fun getInstance() = instance
    }
}