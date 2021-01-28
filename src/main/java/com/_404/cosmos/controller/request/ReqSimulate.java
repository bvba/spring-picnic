package com._404.cosmos.controller.request;

import lombok.Data;

import java.util.List;

@Data
public class ReqSimulate {
    private List<ReqHuman> humanList;
    private List<ReqTrafficLight> trafficLightList;
}

@Data
class ReqHuman {
    private Long id;
    private Integer goal;
}

@Data
class ReqTrafficLight {
    private Long id;
    private Boolean turn;
}
