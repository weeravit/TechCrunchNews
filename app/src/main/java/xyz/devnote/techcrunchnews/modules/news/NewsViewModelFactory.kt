package xyz.devnote.techcrunchnews.modules.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewsViewModelFactory(val service : NewsService) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val repository = NewsFakeRepository()
        val service = NewsService(repository)
        return NewsViewModel(service) as T
    }
}