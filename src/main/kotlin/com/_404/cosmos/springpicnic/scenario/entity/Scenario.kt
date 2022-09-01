package com._404.cosmos.springpicnic.scenario.entity

import javax.persistence.*

@Entity
@Table(name = "scenario")
open class Scenario(
        @Id
        open var id: Long,

        @Column(name = "game_span")
        open var gameSpan: Int,

        @Column(name = "load_size")
        open var loadSize: Int
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