package com.ksb.ksb_with_jpa.dao

import com.ksb.ksb_with_jpa.entity.Article
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRespository : JpaRepository<Article, Long> {

    override fun findAll(pageable: Pageable): Page<Article>

}