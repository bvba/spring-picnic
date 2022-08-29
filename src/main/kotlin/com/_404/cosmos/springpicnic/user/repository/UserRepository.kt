package com._404.cosmos.springpicnic.user.repository

import com._404.cosmos.springpicnic.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User,Long?> {
}