package com._404.cosmos.springpicnic.player.repository

import com._404.cosmos.springpicnic.player.entity.Player
import org.springframework.data.jpa.repository.JpaRepository

interface PlayerRepository : JpaRepository<Player,Long?> {
}