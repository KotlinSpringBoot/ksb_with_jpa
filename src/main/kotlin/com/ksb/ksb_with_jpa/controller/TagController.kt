package com.ksb.ksb_with_jpa.controller

import com.ksb.ksb_with_jpa.dao.TagRepository
import com.ksb.ksb_with_jpa.entity.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tag")
class TagController {
    @Autowired lateinit var TagRepository: TagRepository

    @GetMapping(value = *arrayOf("", "/"))
    fun findPage(@RequestParam(value = "page", defaultValue = "0") page: Int,
                 @RequestParam(value = "size", defaultValue = "10") size: Int): Page<Tag> {
        return TagRepository.findAll(PageRequest.of(page, size))
    }
}
