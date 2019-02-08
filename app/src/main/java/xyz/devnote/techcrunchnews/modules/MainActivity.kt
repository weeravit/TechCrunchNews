package xyz.devnote.techcrunchnews.modules

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import xyz.devnote.techcrunchnews.modules.news.NewsActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NewsActivity.start(this)
        finish()
    }
}
