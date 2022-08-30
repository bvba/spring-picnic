package com._404.cosmos.springpicnic.scenarioPasserby.entity

import com._404.cosmos.springpicnic.scenario.entity.Scenario
import javax.persistence.*

@Entity
@Table(name = "scenario_passerby")
open class ScenarioPasserby(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scenario_id")
    open var scenario: Scenario? = null,

    @Column(name="start_time")
    open var startTime : Int? = null,

    @Column(name="start_pos")
    open var startPos : Int? = null,

    @Column(name = "goal_time")
    open var goalTime : Int? = null,

    @Column(name = "goal_pos")
    open var goalPos : Int? = null
)