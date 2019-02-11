package xyz.devnote.techcrunchnews.modules.news.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("articles")
    var articles: List<Article?>? = listOf(),
    @SerializedName("status")
    var status: String? = "",
    @SerializedName("code")
    var code: String? = "",
    @SerializedName("message")
    var message: String? = "",
    @SerializedName("totalResults")
    var totalResults: Int? = 0
) {
    data class Article(
        @SerializedName("author")
        var author: String? = "",
        @SerializedName("content")
        var content: String? = "",
        @SerializedName("description")
        var description: String? = "",
        @SerializedName("publishedAt")
        var publishedAt: String? = "",
        @SerializedName("source")
        var source: Source? = Source(),
        @SerializedName("title")
        var title: String? = "",
        @SerializedName("url")
        var url: String? = "",
        @SerializedName("urlToImage")
        var urlToImage: String? = ""
    ) {
        data class Source(
            @SerializedName("id")
            var id: String? = "",
            @SerializedName("name")
            var name: String? = ""
        )
    }

    fun isError() = status == "error"
}