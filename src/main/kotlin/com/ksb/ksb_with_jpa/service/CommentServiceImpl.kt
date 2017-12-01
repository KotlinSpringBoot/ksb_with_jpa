package com.ksb.ksb_with_jpa.service

import com.ksb.ksb_with_jpa.dao.CommentRespository
import com.ksb.ksb_with_jpa.entity.Comment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CommentServiceImpl : CommentService {
    override fun findAll(): List<Comment> {
        return commentRespository.findAll()
    }


    override fun save(comment: Comment): Comment {
        return commentRespository.save(comment)
    }


    override fun listPage(pageable: Pageable): Page<Comment> {
        return commentRespository.findAll(pageable)
    }

    @Autowired lateinit var commentRespository: CommentRespository


}
