package com._404.cosmos.controller;

import com._404.cosmos.controller.request.ReqSimulate;
import com._404.cosmos.controller.request.ReqStart;
import com._404.cosmos.controller.response.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static com._404.cosmos.common.Const.USER_ID;
import static com._404.cosmos.common.Const.X_TOKEN;

@RestController
@Slf4j
public class GameController {

    @GetMapping("/humans")
    public List<ReplyHuman> humans(
            @RequestParam(USER_ID) Long userId,
            @RequestHeader(X_TOKEN) String token
    ) {
        return Collections.emptyList();
    }

    @GetMapping("/trafficLights")
    public List<ReplyTrafficLight> trafficLights(
            @RequestParam(USER_ID) Long userId,
            @RequestHeader(X_TOKEN) String token
    ) {
        return Collections.emptyList();
    }

    @GetMapping("/score")
    public ReplyScore score(
            @RequestParam(USER_ID) Long userId,
            @RequestHeader(X_TOKEN) String token
    ) {
        return new ReplyScore();
    }

    @PostMapping("/start")
    public ReplyStart start(
            @RequestBody ReqStart reqStart
    ) {
        return new ReplyStart();
    }

    @PostMapping("/simulate")
    public ReplySimulate simulate(
            @RequestBody ReqSimulate reqSimulate
    ) {
        log.info(reqSimulate.toString());
        return new ReplySimulate();
    }

}
