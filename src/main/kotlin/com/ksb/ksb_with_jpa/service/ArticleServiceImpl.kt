package com.ksb.ksb_with_jpa.service

import com.ksb.ksb_with_jpa.dao.ArticleRespository
import com.ksb.ksb_with_jpa.entity.Article
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ArticleServiceImpl : ArticleService {
    override fun save(article: Article): Article {
        return articleRespository.save(article)
    }

    override fun listPage(pageable: Pageable): Page<Article> {
        return articleRespository.findAll(pageable)
    }

    override fun findAll(): List<Article> {
        return articleRespository.findAll()
    }

    @Autowired lateinit var articleRespository: ArticleRespository

}
