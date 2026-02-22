package com.homeWork.module4Hw.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "currency_conversion")

public class CurrencyConversionEntity extends BaseAuditEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromCurrency;

    private String toCurrency;

    private Double units;

    private Double convertedValue;
}
