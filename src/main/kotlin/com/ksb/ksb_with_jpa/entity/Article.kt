package com.ksb.ksb_with_jpa.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.*

@Entity
class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1

    @Column(length = 100)
    var title: String = ""

    var author: String = ""

    @Column(length = 2000)
    var content: String = ""

    @OneToMany(targetEntity = Comment::class, fetch = FetchType.LAZY)
    lateinit var comments: List<Comment>

    @OneToMany(targetEntity = Tag::class, fetch = FetchType.LAZY)
    lateinit var tags: List<Tag>

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    var gmtCreate: Date = Date()
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    var gmtModify: Date = Date()

    var isDeleted = 0

}
