package xyz.devnote.techcrunchnews.modules.news.business

import kotlinx.coroutines.delay
import xyz.devnote.techcrunchnews.manager.HttpManager
import xyz.devnote.techcrunchnews.modules.news.model.NewsRequest
import xyz.devnote.techcrunchnews.modules.news.model.NewsResponse
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class NewsApiRepository : NewsRepository {
    override suspend fun getNews(request: NewsRequest): NewsResponse {
        return suspendCoroutine {
            HttpManager.getInstance()
                .getNews(request) { response ->
                    it.resume(response!!)
                }
        }
    }
}