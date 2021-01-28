package com._404.cosmos;

import com._404.cosmos.domain.JpaTestModel;
import com._404.cosmos.repository.JpaTestModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class DBInitializer implements CommandLineRunner {

    private final JpaTestModelRepository jpaTestModelRepository;

    @Override
    public void run(String... args) {
        createJpaTestModel();
    }

    private void createJpaTestModel() {
        jpaTestModelRepository.saveAll(
                Stream.generate(JpaTestModel::new)
                        .limit(5)
                        .collect(Collectors.toList()));
    }
}
