package com.ksb.ksb_with_jpa.controller

import com.ksb.ksb_with_jpa.dao.ArticleRespository
import com.ksb.ksb_with_jpa.entity.Article
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/article")
class ArticleController {
    @Autowired lateinit var articleRespository: ArticleRespository

    @GetMapping(value = *arrayOf("", "/"))
    fun findPage(@RequestParam(value = "page", defaultValue = "0") page: Int,
                 @RequestParam(value = "size", defaultValue = "10") size: Int): Page<Article> {
        return articleRespository.findAll(PageRequest.of(page, size))
    }

    @GetMapping(value = "/{id}")
    fun detail(@PathVariable("id") id: Long): Article {
        return articleRespository.getOne(id)
    }
}
