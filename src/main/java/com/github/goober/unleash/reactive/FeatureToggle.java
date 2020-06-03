package com.github.goober.unleash.reactive;

import no.finn.unleash.Unleash;
import no.finn.unleash.UnleashContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class FeatureToggle {

    @Autowired
    private Unleash unleash;

    Mono<Boolean> isEnabled(String toggle) {
        return Mono.subscriberContext()
                .map(context -> context.getOrDefault(UnleashContext.class, Mono.just(UnleashContext.builder().build())))
                .flatMap(context -> context.map(c -> unleash.isEnabled(toggle, c)));
    }
}
