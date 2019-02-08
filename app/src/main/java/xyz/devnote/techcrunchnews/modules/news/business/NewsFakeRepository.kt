package xyz.devnote.techcrunchnews.modules.news.business

import kotlinx.coroutines.delay
import xyz.devnote.techcrunchnews.modules.news.model.NewsRequest
import xyz.devnote.techcrunchnews.modules.news.model.NewsResponse
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class NewsFakeRepository : NewsRepository {
    override suspend fun getNews(request: NewsRequest): NewsResponse {
        delay(2000)

        return suspendCoroutine {
            it.resume(NewsResponse())
        }
    }
}