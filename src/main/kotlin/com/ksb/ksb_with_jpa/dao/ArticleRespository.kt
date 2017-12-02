package com.ksb.ksb_with_jpa.dao

import com.ksb.ksb_with_jpa.entity.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRespository : JpaRepository<Article, Long> {
}