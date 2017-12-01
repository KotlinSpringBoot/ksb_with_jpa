package com.ksb.ksb_with_jpa.controller

import com.ksb.ksb_with_jpa.dao.ArticleCommentRespository
import com.ksb.ksb_with_jpa.entity.ArticleComment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/article_comment")
class ArticleCommentController {
    @Autowired lateinit var ArticleCommentRespository: ArticleCommentRespository


    @GetMapping(value = "/getPage")
    fun findPage(@RequestParam(value = "page", defaultValue = "0") page: Int,
                 @RequestParam(value = "size", defaultValue = "10") size: Int): Page<ArticleComment> {
        return ArticleCommentRespository.findAll(PageRequest.of(page, size))
    }

}
