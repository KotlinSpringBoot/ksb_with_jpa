package com.ksb.ksb_with_jpa.controller

import com.ksb.ksb_with_jpa.dao.CommentRespository
import com.ksb.ksb_with_jpa.entity.Comment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/comment")
class CommentController {
    @Autowired lateinit var commentRespository: CommentRespository

    @GetMapping(value = *arrayOf("", "/"))
    fun listAll(): List<Comment> {
        return commentRespository.findAll()
    }

    @GetMapping(value = "/listPage")
    fun listPage(@RequestParam(value = "page", defaultValue = "0") page: Int,
                 @RequestParam(value = "size", defaultValue = "10") size: Int): Page<Comment> {
        val pageRequest = PageRequest.of(page, size)
        return commentRespository.listPage(pageRequest)
    }

    @GetMapping(value = "/findPage")
    fun findPage(@RequestParam(value = "page", defaultValue = "0") page: Int,
                 @RequestParam(value = "size", defaultValue = "10") size: Int): Page<Comment> {
        val pageRequest = PageRequest.of(page, size)
        return commentRespository.findAll(pageRequest)
    }

}
