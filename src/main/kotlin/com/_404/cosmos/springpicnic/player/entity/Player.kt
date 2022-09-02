package com._404.cosmos.springpicnic.player.entity

import com._404.cosmos.springpicnic.scenario.entity.Scenario
import com._404.cosmos.springpicnic.game.GameStatus
import com._404.cosmos.springpicnic.game.converter.GameStatusConverter
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "player")
open class Player(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        open var id: Long? = null,

        @Column(name="auth_token")
        open var autoToken: String,

        @Column(name="created_at")
        open var createdAt:LocalDateTime = LocalDateTime.now(),

        @Column(name="expire_at")
        open var expireAt:LocalDateTime? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "scenario_id")
        open var scenario: Scenario? = null,

        @Column(name = "game_time")
        open var gameTime: Int? = null,

        @Convert(converter = GameStatusConverter::class)
        @Column(name = "game_status")
        open var gameStatus: GameStatus = GameStatus.NONE
)


