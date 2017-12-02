package com.ksb.ksb_with_jpa.dao

import com.ksb.ksb_with_jpa.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRespository : JpaRepository<Comment, Long> {
}
