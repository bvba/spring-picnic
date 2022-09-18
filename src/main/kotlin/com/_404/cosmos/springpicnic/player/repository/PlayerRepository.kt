package com._404.cosmos.springpicnic.player.repository

import com._404.cosmos.springpicnic.player.entity.Player
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PlayerRepository : JpaRepository<Player,Long?> {
	fun findByAuthToken(authToken: String) : Optional<Player>
}