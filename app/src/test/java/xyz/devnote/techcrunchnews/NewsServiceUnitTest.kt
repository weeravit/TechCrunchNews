package xyz.devnote.techcrunchnews

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import xyz.devnote.techcrunchnews.modules.news.business.NewsFakeRepository
import xyz.devnote.techcrunchnews.modules.news.business.NewsRepository
import xyz.devnote.techcrunchnews.modules.news.business.NewsService
import xyz.devnote.techcrunchnews.modules.news.model.NewsRequest

class NewsServiceUnitTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    private lateinit var repository: NewsRepository
    private lateinit var service: NewsService

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        repository = NewsFakeRepository()
        service = NewsService(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun Should_Has20Articles_When_RequestPageOne() {
        runBlocking {
            val request = NewsRequest(page = 1)
            val data = service.getNews(request)

            Assert.assertEquals(20, data.result?.articles?.size)
        }
    }

    @Test
    fun Should_Error_When_RequestPageLessThanOne() {
        runBlocking {
            val request = NewsRequest(page = 0)
            val data = service.getNews(request)

            Assert.assertEquals(true, data.isError)
        }
    }
}