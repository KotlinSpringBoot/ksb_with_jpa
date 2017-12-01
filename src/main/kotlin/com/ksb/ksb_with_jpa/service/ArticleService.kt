package com.ksb.ksb_with_jpa.service

import com.ksb.ksb_with_jpa.entity.Article
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ArticleService {
    fun save(Article: Article): Article

    fun listPage(pageable: Pageable): Page<Article>

    fun findAll(): List<Article>
}
