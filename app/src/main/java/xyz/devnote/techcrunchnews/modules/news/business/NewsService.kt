package xyz.devnote.techcrunchnews.modules.news.business

import xyz.devnote.techcrunchnews.common.Data
import xyz.devnote.techcrunchnews.modules.news.model.NewsRequest
import xyz.devnote.techcrunchnews.modules.news.model.NewsResponse

class NewsService(private val repository: NewsRepository) {

    suspend fun getNews(request: NewsRequest): Data<NewsResponse> {
        val response = repository.getNews(request)

        // TODO : Do something with business logic such as cache data...

        return response
    }
}