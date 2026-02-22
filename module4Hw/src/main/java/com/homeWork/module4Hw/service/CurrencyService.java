package com.homeWork.module4Hw.service;

import com.homeWork.module4Hw.client.CurrencyApiClient;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private static final Logger log =
            LoggerFactory.getLogger(CurrencyService.class);

    private final CurrencyApiClient apiClient;

    public double convert(String fromCurrency,String toCurrency,Double units){
        log.info("Starting currency conversion: {} -> {}, Units: {}",
                fromCurrency, toCurrency, units);

        Double rate=apiClient.getExchangeRATE(fromCurrency,toCurrency);

        log.info("Received exchange rate: {}", rate);

        if(rate==null){
            throw new RuntimeException("Invalid currency code");
        }

        double res=units*rate;
        log.info("Conversion completed. Result: {}", res);
        return res;
    }
}
