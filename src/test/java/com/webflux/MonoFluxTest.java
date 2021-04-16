package com.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.Flow;

public class MonoFluxTest {

    @Test
    public void testMono() {
        Mono<?> monoString = Mono.just("javadoc").then(Mono.error(new RuntimeException("Error on Mono"))).log();
        monoString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));

    }

    @Test
    public void testFlux() {
        Flux<?> flux=Flux.just("Spring","SpringBoot","Hibernate")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Error on Flux")))
                .concatWithValues("CloudAWS")
                .log();
        flux.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));

    }
}

