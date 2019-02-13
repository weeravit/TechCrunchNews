package xyz.devnote.techcrunchnews.modules.news.business

import xyz.devnote.techcrunchnews.common.Data
import xyz.devnote.techcrunchnews.manager.api.HttpManager
import xyz.devnote.techcrunchnews.manager.api.InterceptCallback
import xyz.devnote.techcrunchnews.modules.news.model.NewsRequest
import xyz.devnote.techcrunchnews.modules.news.model.NewsResponse
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class NewsApiRepository : NewsRepository {
    override suspend fun getNews(request: NewsRequest): Data<NewsResponse> {
        return suspendCoroutine {
            HttpManager.getNews(request, object : InterceptCallback<NewsResponse>() {
                override fun onSuccess(result: NewsResponse?) {
                    it.resume(
                        Data(
                            isError = result?.isError() ?: false,
                            message = result?.message ?: "",
                            result = result
                        )
                    )
                }

                override fun onFailure(message: String?) {
                    it.resume(
                        Data(
                            isError = true,
                            message = message ?: ""
                        )
                    )
                }
            })
        }
    }
}