package com._404.cosmos.springpicnic.test.repository

import com._404.cosmos.springpicnic.test.TestEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestRepository : JpaRepository<TestEntity, Long> {
}
