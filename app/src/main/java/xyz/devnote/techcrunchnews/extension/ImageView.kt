package xyz.devnote.techcrunchnews.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadByUrl(url: String) {
    Glide.with(this)
        .load(url)
        .into(this)
}