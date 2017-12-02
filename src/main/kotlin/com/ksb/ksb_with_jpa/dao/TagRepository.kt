package com.ksb.ksb_with_jpa.dao

import com.ksb.ksb_with_jpa.entity.Tag
import org.springframework.data.jpa.repository.JpaRepository

interface TagRepository : JpaRepository<Tag, Long> {
}