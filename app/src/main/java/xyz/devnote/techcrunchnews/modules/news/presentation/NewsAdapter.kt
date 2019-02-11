package xyz.devnote.techcrunchnews.modules.news.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item_news.view.*
import xyz.devnote.techcrunchnews.R
import xyz.devnote.techcrunchnews.common.extension.loadByUrl
import xyz.devnote.techcrunchnews.modules.news.model.News

class NewsAdapter(private val items : ArrayList<News>,
                  private val listener : Listener
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    fun addItems(items : ArrayList<News>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {
            val item = getCurrentItem()

            itemView.text_title.text = item.title
            itemView.image_news.loadByUrl(item.imageUrl)
        }

        private val onNewsClickListener = View.OnClickListener {
            val item = getCurrentItem()

            listener.onNewsClick(item)
        }

        private fun getCurrentItem() = items[adapterPosition]

        init {
            itemView.layout.setOnClickListener(onNewsClickListener)
        }
    }

    interface Listener {
        fun onNewsClick(news : News)
    }
}