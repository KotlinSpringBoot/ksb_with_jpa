package com.ksb.ksb_with_jpa.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.*

@Entity
open class ArticleComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1

    @OneToOne(targetEntity = Article::class, fetch = FetchType.LAZY)
    lateinit var article: Article

    @OneToOne(targetEntity = Comment::class, fetch = FetchType.LAZY)
    lateinit var comment: Comment

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    var gmtCreate: Date = Date()
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    var gmtModify: Date = Date()


}
