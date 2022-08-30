package com._404.cosmos.springpicnic.score.entity

import com._404.cosmos.springpicnic.scenario.entity.Scenario
import com._404.cosmos.springpicnic.user.entity.User
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "score")
open class Score (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    open var user: User? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scenario_id")
    open var scenario: Scenario? = null,

    @Column(name="score")
    open var score: Int? = null,

    @Column(name="scored_at")
    open var scoredAt: LocalDateTime? = null
)