package xyz.devnote.techcrunchnews.modules.news

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.devnote.techcrunchnews.R

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
    }

    companion object {
        fun start(context : Context?) {
            val intent = Intent(context, NewsActivity::class.java)
            context?.startActivity(intent)
        }
    }
}
