package com._404.cosmos.springpicnic.passerby.entity

import com._404.cosmos.springpicnic.user.entity.User
import javax.persistence.*


@Entity
@Table(name = "passerby")
open class Passerby (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    open var user: User? = null,

    @Column(name = "pos")
    open var pos: Int? = null,
    
    @Column(name = "arrival_time")
    open var arrivalTime: Int? = null
)