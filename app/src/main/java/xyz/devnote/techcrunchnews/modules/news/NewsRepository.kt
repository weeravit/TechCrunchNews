package xyz.devnote.techcrunchnews.modules.news

import xyz.devnote.techcrunchnews.modules.news.model.NewsRequest
import xyz.devnote.techcrunchnews.modules.news.model.NewsResponse

interface NewsRepository {
    suspend fun getNews(request: NewsRequest): NewsResponse
}