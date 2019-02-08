package xyz.devnote.techcrunchnews.modules.news.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import xyz.devnote.techcrunchnews.R
import xyz.devnote.techcrunchnews.modules.news.business.NewsFakeRepository
import xyz.devnote.techcrunchnews.modules.news.business.NewsService

class NewsActivity : AppCompatActivity(), LifecycleOwner {

    private val viewModel by lazy {
        val repository = NewsFakeRepository()
        val service = NewsService(repository)
        val factory = NewsViewModel.factory(service)

        ViewModelProviders.of(this, factory).get(NewsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        initViews()
        initViewModelListener()

        viewModel.getNews()
    }

    private fun initViews() {

    }

    private fun initViewModelListener() {
        viewModel.whenNewsError.observe(this, Observer {
            Toast.makeText(this@NewsActivity, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.whenNewsLoaded.observe(this, Observer {

        })
    }

    companion object {
        fun start(context: Context?) {
            val intent = Intent(context, NewsActivity::class.java)
            context?.startActivity(intent)
        }
    }
}
