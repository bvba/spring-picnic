package com._404.cosmos.springpicnic.scenario.entity

import javax.persistence.*

@Entity
@Table(name = "scenario")
open class Scenario(
        @Id
        var id: Long? = null,

        @Column(name = "game_span")
        var gameSpan: Int? = null,

        @Column(name = "load_size")
        var loadSize: Int? = null
)