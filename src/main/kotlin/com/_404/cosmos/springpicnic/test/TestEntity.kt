package com._404.cosmos.springpicnic.test

import lombok.Getter
import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Getter
class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
        private set

    @Column
    var dateTime: ZonedDateTime = ZonedDateTime.now()
        private set
}
