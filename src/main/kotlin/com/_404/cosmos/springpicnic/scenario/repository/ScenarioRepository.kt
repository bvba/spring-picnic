package com._404.cosmos.springpicnic.scenario.repository

import com._404.cosmos.springpicnic.scenario.entity.Scenario
import org.springframework.data.jpa.repository.JpaRepository

interface ScenarioRepository : JpaRepository<Scenario, Long?> {

}