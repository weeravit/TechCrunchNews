package xyz.devnote.techcrunchnews.modules.news.business

import kotlinx.coroutines.delay
import xyz.devnote.techcrunchnews.common.Data
import xyz.devnote.techcrunchnews.modules.news.model.NewsRequest
import xyz.devnote.techcrunchnews.modules.news.model.NewsResponse
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class NewsFakeRepository : NewsRepository {
    override suspend fun getNews(request: NewsRequest): Data<NewsResponse> {
        delay(2000)

        return suspendCoroutine {
            val data = Data(
                result = NewsResponse()
            )

            it.resume(data)
        }
    }
}