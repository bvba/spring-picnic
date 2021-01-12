package com._404.cosmos.repository;

import com._404.cosmos.domain.JpaTestModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTestModelRepository extends JpaRepository<JpaTestModel, Long> {

    JpaTestModel findByName(String name);

}
