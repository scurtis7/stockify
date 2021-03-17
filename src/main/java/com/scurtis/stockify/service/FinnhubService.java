package com.scurtis.stockify.service;

import com.scurtis.stockify.model.FHQuote;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class FinnhubService {

    @Value("${finnhub.token}")
    private String token;

    private final WebClient finnhubWebClient;

    private final ParameterizedTypeReference<FHQuote> quoteType = new ParameterizedTypeReference<>() {
    };

    public Mono<FHQuote> getQuote(String symbol) {
        return finnhubWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/quote")
                        .queryParam("symbol", symbol)
                        .queryParam("token", token)
                        .build())
                .retrieve()
                .bodyToMono(quoteType);
    }


}
