package com._404.cosmos.springpicnic.scenario.entity

import javax.persistence.*

@Entity
@Table(name = "scenario")
open class Scenario(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        open var id: Long? = null,

        @Column(name = "game_span")
        open var gameSpan: Int? = null,

        @Column(name = "load_size")
        open var loadSize: Int? = null


)