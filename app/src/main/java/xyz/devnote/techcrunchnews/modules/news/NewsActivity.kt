package xyz.devnote.techcrunchnews.modules.news

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import xyz.devnote.techcrunchnews.R

class NewsActivity : AppCompatActivity(), LifecycleOwner {

    private val viewModel by lazy {
        val repository = NewsFakeRepository()
        val service = NewsService(repository)
        val factory = NewsViewModelFactory(service)

        ViewModelProviders.of(this, factory).get(NewsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        initListener()
        initViews()
    }

    private fun initViews() {

    }

    private fun initListener() {
        viewModel.whenNewsError.observe(this, Observer {

        })

        viewModel.whenNewsLoaded.observe(this, Observer {

        })
    }

    companion object {
        fun start(context : Context?) {
            val intent = Intent(context, NewsActivity::class.java)
            context?.startActivity(intent)
        }
    }
}
