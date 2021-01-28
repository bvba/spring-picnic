package com._404.cosmos.controller.response;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class ReplySimulate {
    private List<ReplyHumanResult> humanResultList = Collections.emptyList();
    private List<ReplyTrafficLightResult> trafficLightResultList = Collections.emptyList();
}

@Data
class ReplyHumanResult {
    private Long id = 0L;
    private Boolean success = false;
}

@Data
class ReplyTrafficLightResult {
    private Long id = 0L;
    private Boolean success = false;
}
