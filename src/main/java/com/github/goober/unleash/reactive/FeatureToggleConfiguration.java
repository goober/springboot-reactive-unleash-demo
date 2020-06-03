package com.github.goober.unleash.reactive;

import no.finn.unleash.DefaultUnleash;
import no.finn.unleash.Unleash;
import no.finn.unleash.util.UnleashConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeatureToggleConfiguration {

    @Bean
    Unleash unleash(@Value("${unleash.host}") String unleash) {
        UnleashConfig config = UnleashConfig.builder()
                .appName("java-test")
                .instanceId("instance x")
                .unleashAPI(unleash)
                .build();

        return new DefaultUnleash(config);
    }

}
