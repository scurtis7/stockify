package com.scurtis.stockify.controller;

import com.scurtis.stockify.model.AVQuote;
import com.scurtis.stockify.service.AlphaVantageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/api/av")
@RequiredArgsConstructor
public class AlphaVantageController {

    private final AlphaVantageService alphaVantageService;

    @GetMapping("/quote/{symbol}")
    public Mono<AVQuote> getAlphaVantageQuote(@PathVariable String symbol) {
        return alphaVantageService.getQuote(symbol);
    }


}
