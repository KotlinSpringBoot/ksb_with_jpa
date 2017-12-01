package com.ksb.ksb_with_jpa.dao

import com.ksb.ksb_with_jpa.entity.ArticleComment
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ArticleCommentRespository : JpaRepository<ArticleComment, Long> {

    override fun findAll(pageable: Pageable): Page<ArticleComment>

    @Query("select a from #{#entityName} a where a.article.id = :articleId")
    fun findCommentsByArticleId(
        @Param("articleId") articleId: Long,
        pageable: Pageable
    ): Page<ArticleComment>
}