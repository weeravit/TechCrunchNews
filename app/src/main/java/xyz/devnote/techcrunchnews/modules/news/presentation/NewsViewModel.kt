package xyz.devnote.techcrunchnews.modules.news.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import xyz.devnote.techcrunchnews.modules.news.business.NewsService
import xyz.devnote.techcrunchnews.modules.news.model.News
import xyz.devnote.techcrunchnews.modules.news.model.NewsRequest

class NewsViewModel(private val service: NewsService) : ViewModel() {

    val whenNewsError = MutableLiveData<String>()
    val whenNewsLoaded = MutableLiveData<ArrayList<News>>()

    fun getNews(page: Int = 1) {
        GlobalScope.launch(Dispatchers.Main) {
            val request = NewsRequest(page = page)
            val data = service.getNews(request)

            if (data.isError) {
                whenNewsError.postValue(data.message)
                return@launch
            }

            val items = data.result?.articles?.map {
                News(
                    title = it?.title ?: "",
                    imageUrl = it?.urlToImage ?: "",
                    link = it?.url ?: ""
                )
            }

            whenNewsLoaded.postValue(ArrayList(items))
        }
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