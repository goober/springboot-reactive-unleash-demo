package com.github.goober.unleash.reactive;

import no.finn.unleash.UnleashContext;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;
import java.security.Principal;
import java.util.Optional;

@Component
public class UnleashContextFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return chain.filter(exchange).subscriberContext(ctx -> {
            Mono<UnleashContext> unleashContext = exchange.getPrincipal()
                    .map(Principal::getName)
                    .map(user -> UnleashContext.builder()
                            .userId(user)
                            .remoteAddress(Optional.ofNullable(exchange.getRequest().getRemoteAddress())
                                    .map(InetSocketAddress::getHostString)
                                    .orElse(""))
                            .build());

            return ctx.put(UnleashContext.class, unleashContext);

        });
    }
}
