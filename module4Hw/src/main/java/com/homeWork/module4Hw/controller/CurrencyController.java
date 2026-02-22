package com.homeWork.module4Hw.controller;

import com.homeWork.module4Hw.dto.CurrencyConversionDTO;
import com.homeWork.module4Hw.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private static final Logger log =
            LoggerFactory.getLogger(CurrencyController.class);

    private final CurrencyService currencyService;

    @GetMapping("/convertCurrency")
    public CurrencyConversionDTO convertCurrency(
            @RequestParam String fromCurrency,
            @RequestParam String toCurrency,
            @RequestParam Double units
    ){
        log.info("Received API request: from={}, to={}, units={}",
                fromCurrency, toCurrency, units);

        Double convertedValue= currencyService.convert(fromCurrency,toCurrency,units);

        log.info("Sending response to client");

        return new CurrencyConversionDTO(fromCurrency,toCurrency,units,convertedValue);
    }
}
