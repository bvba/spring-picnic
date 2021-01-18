package com._404.cosmos.domain;

import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@Entity
public class JpaTestModel implements Serializable {

    public JpaTestModel() {
        this.name = RandomStringUtils.randomAlphanumeric(5);
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

}
