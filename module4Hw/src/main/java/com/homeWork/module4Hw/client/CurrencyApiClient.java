package com.homeWork.module4Hw.client;

import com.homeWork.module4Hw.dto.CurrencyApiResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class CurrencyApiClient {
    private static final Logger log =
            LoggerFactory.getLogger(CurrencyApiClient.class);


    private final RestClient restClient;

    @Value("${currency.api.key}")
    private String apiKey;

    public Double getExchangeRATE(String fromCurrency,String toCurrency){

        log.info("Calling FreeCurrency API: Base={}, Target={}",
                fromCurrency, toCurrency);

        String url = "https://api.freecurrencyapi.com/v1/latest"
                + "?apikey=" + apiKey
                + "&base_currency=" + fromCurrency
                + "&currencies=" + toCurrency;

        log.debug("API URL: {}", url);

        CurrencyApiResponse response=restClient.get().uri(url)
                .retrieve().body(CurrencyApiResponse.class);

        double rate= response.getData().get(toCurrency);
        log.info("API Response Rate: {}", rate);

        return rate;
    }

}
