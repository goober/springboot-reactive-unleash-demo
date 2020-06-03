package com.github.goober.unleash.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FeatureToggleController {

    @Autowired
    private FeatureToggle featureToggle;

    @GetMapping(value = "/toggle", produces = "application/json")
    public Mono<String> toggle() {
        return featureToggle.isEnabled("toggle")
                .map(enabled -> "{\"toggle\":\"" + (enabled ? "enabled" : "disabled") + "\"}");
    }
}
