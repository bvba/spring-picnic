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
){
        override fun equals(other: Any?): Boolean {
                if (other !is Scenario) {
                        return false
                }
                return this.id == other.id
                        && this.gameSpan == other.gameSpan
                        && this.loadSize == other.loadSize
        }
}