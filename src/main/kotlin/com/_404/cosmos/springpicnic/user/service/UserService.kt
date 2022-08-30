package com._404.cosmos.springpicnic.user.service

import com._404.cosmos.springpicnic.scenario.entity.Scenario
import com._404.cosmos.springpicnic.user.entity.User
import java.time.LocalDateTime

interface UserService {
    fun startScenario(userId: Long, scenarioId: Long)
    fun terminateScenario(userId: Long)
    fun createUserExpireAfterMonth(authToken:String )

}