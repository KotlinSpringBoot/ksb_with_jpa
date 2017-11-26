package com.ksb.ksb_with_jpa.dao

import com.ksb.ksb_with_jpa.entity.Comment
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CommentRespository : JpaRepository<Comment, Long> {

    @Query("select a from #{#entityName} a")
    fun listPage(pageable: Pageable): Page<Comment>

    override fun findAll(pageable: Pageable): Page<Comment>

}
