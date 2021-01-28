package com._404.cosmos.controller;

import com._404.cosmos.IntegrationSupport;
import com._404.cosmos.controller.request.ReqSimulate;
import com._404.cosmos.controller.request.ReqStart;
import com._404.cosmos.controller.response.*;
import com.google.common.truth.Truth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

class GameControllerTests extends IntegrationSupport {

    private final GameController gameController;

    @Autowired
    public GameControllerTests(GameController gameController) {
        this.gameController = gameController;
    }

    @DisplayName("humans api 테스트")
    @Test
    void humansTest() {
        // given

        // when
        List<ReplyHuman> humans = gameController.humans(0L, "");

        // then
        Truth.assertThat(humans.isEmpty()).isTrue();
    }

    @DisplayName("trafficLights api 테스트")
    @Test
    void trafficLightsTest() {
        // given

        // when
        List<ReplyTrafficLight> trafficLights = gameController.trafficLights(0L, "");

        // then
        Truth.assertThat(trafficLights.isEmpty()).isTrue();
    }

    @DisplayName("score api 테스트")
    @Test
    void scoreTest() {
        // given

        // when
        ReplyScore score = gameController.score(0L, "");

        // then
        Truth.assertThat(score.getLightOnScore()).isLessThan(1);
        Truth.assertThat(score.getPatienceScore()).isLessThan(1);
    }

    @DisplayName("start api 테스트")
    @Test
    void startTest() {
        // given

        // when
        ReplyStart replyStart = gameController.start(new ReqStart());

        // then
        Truth.assertThat(replyStart.getId()).isAtLeast(0);
    }

    @DisplayName("simulate api 테스트")
    @Test
    void simulateTest() {
        // given

        // when
        ReplySimulate replySimulate = gameController.simulate(new ReqSimulate(Collections.emptyList(), Collections.emptyList()));

        // then
        Truth.assertThat(replySimulate.getHumanResultList().isEmpty()).isTrue();
        Truth.assertThat(replySimulate.getTrafficLightResultList().isEmpty()).isTrue();
    }

}
