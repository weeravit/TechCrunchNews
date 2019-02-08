package xyz.devnote.techcrunchnews.modules.news.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import xyz.devnote.techcrunchnews.modules.news.business.NewsService
import xyz.devnote.techcrunchnews.modules.news.model.News
import xyz.devnote.techcrunchnews.modules.news.model.NewsRequest

class NewsViewModel(private val service: NewsService) : ViewModel() {

    val whenNewsError = MutableLiveData<String>()
    val whenNewsLoaded = MutableLiveData<List<News>>()

    suspend fun getNews(page: Int = 1) {
        val request = NewsRequest(page = page)
        val response = service.getNews(request)

        if (response.isError()) {
            whenNewsError.postValue(response.message)
            return
        }

        val items = response.articles?.map {
            News(
                title = it?.title ?: "",
                imageUrl = it?.urlToImage ?: "",
                link = it?.url ?: ""
            )
        }

        whenNewsLoaded.postValue(items)
    }

    companion object {
        fun factory(service : NewsService): ViewModelProvider.NewInstanceFactory {
            return object : ViewModelProvider.NewInstanceFactory() {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return NewsViewModel(service) as T
                }
            }
        }
    }
}