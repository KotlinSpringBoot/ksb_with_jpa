package com.ksb.ksb_with_jpa.service

import com.ksb.ksb_with_jpa.entity.Comment
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CommentService {
    fun save(comment: Comment): Comment

    fun listPage(pageable: Pageable): Page<Comment>

    fun findAll():List<Comment>
}
