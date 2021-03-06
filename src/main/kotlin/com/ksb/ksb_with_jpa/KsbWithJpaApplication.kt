package com.ksb.ksb_with_jpa

import com.ksb.ksb_with_jpa.dao.TagRepository
import com.ksb.ksb_with_jpa.entity.Article
import com.ksb.ksb_with_jpa.entity.Comment
import com.ksb.ksb_with_jpa.entity.Tag
import com.ksb.ksb_with_jpa.service.ArticleService
import com.ksb.ksb_with_jpa.service.CommentService
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.support.beans

@SpringBootApplication
class KsbWithJpaApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder().initializers(
            beans {
                bean {
                    ApplicationRunner {

                        val articleService = ref<ArticleService>()
                        val article = Article()

                        article.title = "Kotlin + Spring Boot: 下一代 J2EE 服务端开发"
                        article.content = "尽情享受 Kotlin + Spring Boot 服务端开发乐趣！"
                        article.author = "东海陈光剑"

                        val tagRepository: TagRepository = ref<TagRepository>()
                        val tag1 = Tag()
                        tag1.name = "Kotlin"
                        val tag1Saved = tagRepository.save(tag1)
                        val tag2 = Tag()
                        tag2.name = "Spring Boot"
                        val tag2Saved = tagRepository.save(tag2)
                        article.tags = listOf(tag1Saved, tag2Saved)


                        val comments = mutableListOf<Comment>()
                        val commentService = ref<CommentService>()
                        repeat(10) { i ->
                            val comment = Comment()
                            comment.author = "Jack"
                            comment.content = "评论${i + 1} : KSB 真的非常好！"
                            val savedComment = commentService.save(comment)
                            comments.add(savedComment)
                        }

                        article.comments = comments
                        articleService.save(article)
                    }

                }
            }
    ).sources(KsbWithJpaApplication::class.java).run(*args)
}

