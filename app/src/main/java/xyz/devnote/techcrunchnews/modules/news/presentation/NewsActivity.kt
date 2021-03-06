package xyz.devnote.techcrunchnews.modules.news.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_news.*
import xyz.devnote.techcrunchnews.modules.news.business.NewsApiRepository
import xyz.devnote.techcrunchnews.modules.news.business.NewsService
import xyz.devnote.techcrunchnews.modules.news.model.News
import xyz.devnote.techcrunchnews.utils.EndlessScrollListener
import android.net.Uri
import xyz.devnote.techcrunchnews.R


class NewsActivity : AppCompatActivity(), NewsAdapter.Listener, EndlessScrollListener.Listener {

    private val viewModel by lazy {
        val repository = NewsApiRepository()
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
        recyclerview.apply {
            val linearLayoutManager = LinearLayoutManager(this@NewsActivity)
            layoutManager = linearLayoutManager
            adapter = NewsAdapter(arrayListOf(), this@NewsActivity)
            addOnScrollListener(EndlessScrollListener(linearLayoutManager, this@NewsActivity))
        }
    }

    private fun initViewModelListener() {
        viewModel.whenNewsError.observe(this, Observer {
            Toast.makeText(this@NewsActivity, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.whenNewsLoaded.observe(this, Observer {
            val adapter = recyclerview.adapter as NewsAdapter
            adapter.addItems(it)
        })
    }

    override fun onNewsClick(news: News) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(news.link))
        startActivity(intent)
    }

    override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
        viewModel.getNews(page = page)
    }

    companion object {
        fun start(context: Context?) {
            val intent = Intent(context, NewsActivity::class.java)
            context?.startActivity(intent)
        }
    }
}
