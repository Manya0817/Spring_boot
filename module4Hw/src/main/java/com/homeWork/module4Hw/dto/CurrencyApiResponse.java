package com.homeWork.module4Hw.dto;

import lombok.Data;
import java.util.Map;

@Data
public class CurrencyApiResponse {
    private Map<String, Double> data;
}
