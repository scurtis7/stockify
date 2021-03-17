package com.scurtis.stockify.service;

import com.scurtis.stockify.model.AVQuote;
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
public class AlphaVantageService {

    @Value("${alphavantage.token}")
    private String token;

    private final WebClient alphavantageWebClient;

    private final ParameterizedTypeReference<AVQuote> quoteType = new ParameterizedTypeReference<>() {
    };

    public Mono<AVQuote> getQuote(String symbol) {
        return alphavantageWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/query")
                        .queryParam("function", "GLOBAL_QUOTE")
                        .queryParam("symbol", symbol)
                        .queryParam("apikey", token)
                        .build())
                .retrieve()
                .bodyToMono(quoteType);
    }

}
