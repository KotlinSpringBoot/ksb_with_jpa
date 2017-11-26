package com.ksb.ksb_with_jpa

import com.ksb.ksb_with_jpa.entity.Comment
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
                        val commentService = ref<CommentService>()
                        val comment = Comment()
                        comment.author = "东海陈光剑"
                        comment.content = "Kotlin + Spring Boot: 下一代 J2EE 服务端开发"
                        commentService.save(comment)
                    }

                }
            }
    ).sources(KsbWithJpaApplication::class.java).run(*args)
}

