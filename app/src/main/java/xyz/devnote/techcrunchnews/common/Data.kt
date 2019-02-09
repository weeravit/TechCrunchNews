package xyz.devnote.techcrunchnews.common

class Data<T>(
    val isError : Boolean = false,
    val message : String = "",
    val result : T? = null
)