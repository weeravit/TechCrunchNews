package xyz.devnote.techcrunchnews.modules.news.business

import xyz.devnote.techcrunchnews.modules.news.model.NewsRequest
import xyz.devnote.techcrunchnews.modules.news.model.NewsResponse

class NewsService(val repository: NewsRepository) {

    suspend fun getNews(request: NewsRequest): NewsResponse {
        val response = repository.getNews(request)

        // TODO : Do something with business logic

        return response
    }
}