package com.scurtis.stockify.service;

import com.scurtis.stockify.model.Quote;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class FinnhubService {

    @Value("finnhub.token")
    private String token;

    private final WebClient finnhubWebClient;

    private final ParameterizedTypeReference<Quote> quoteType = new ParameterizedTypeReference<>() {
    };

    public Mono<Quote> getQuote(String symbol) {
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
