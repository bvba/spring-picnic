package com._404.cosmos.springpicnic.trafficLight.entity

import com._404.cosmos.springpicnic.user.entity.User
import javax.persistence.*

@Entity
@Table(name = "traffic_light")
open class TrafficLight (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    open var user: User? = null,

    @Column(name = "pos")
    open var pos: Int? = null,

    @Column(name = "is_green_light")
    open var isGreenLight: Boolean = false,

    @Column(name = "green_light_maintained_time")
    open var greenLightMaintainedTime : Int = 0

)