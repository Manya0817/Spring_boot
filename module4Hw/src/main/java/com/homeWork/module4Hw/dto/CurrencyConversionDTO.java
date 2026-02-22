package com.homeWork.module4Hw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversionDTO {
    private String fromCurrency;
    private String toCurrency;
    private Double units;
    private Double convertedValue;
}
