package com.ksb.ksb_with_jpa

import com.ksb.ksb_with_jpa.service.ArticleService
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class KsbWithJpaApplicationTests {
    @Autowired lateinit var articleService: ArticleService

    @Test
    fun testArticles() {
        val page = articleService.listPage(PageRequest.of(0, 3))
        Assert.assertTrue(page.content.size > 0)
    }

    @Test
    fun contextLoads() {
    }

}
