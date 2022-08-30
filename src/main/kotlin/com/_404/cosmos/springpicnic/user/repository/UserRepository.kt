package com._404.cosmos.springpicnic.user.repository

import com._404.cosmos.springpicnic.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository : JpaRepository<User,Long?> {
    fun findByAuthToken(authToken: String) : Optional<User>
}