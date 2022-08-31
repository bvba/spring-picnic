package com._404.cosmos.springpicnic.user.entity

import com._404.cosmos.springpicnic.scenario.entity.Scenario
import com._404.cosmos.springpicnic.game.GameStatus
import com._404.cosmos.springpicnic.game.converter.GameStatusConverter
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "users")
open class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,

        @Column(name="auth_token")
        var autoToken: String? = null,

        @Column(name="created_at")
        var createdAt:LocalDateTime = LocalDateTime.now(),

        @Column(name="expire_at")
        var expireAt:LocalDateTime? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "scenario_id")
        var scenario: Scenario? = null,

        @Column(name = "game_time")
        var gameTime: Int? = null,

        @Convert(converter = GameStatusConverter::class)
        @Column(name = "game_status")
        var gameStatus: GameStatus?  = null
)


