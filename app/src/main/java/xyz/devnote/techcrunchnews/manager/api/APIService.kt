package xyz.devnote.techcrunchnews.manager.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import xyz.devnote.techcrunchnews.common.Constants
import xyz.devnote.techcrunchnews.modules.news.model.NewsResponse

interface APIService {
    @GET("everything?sources=${Constants.SOURCE_NEWS}&apiKey=${Constants.API_KEY}")
    fun getNews(@Query("page") page : Int) : Call<NewsResponse>
}