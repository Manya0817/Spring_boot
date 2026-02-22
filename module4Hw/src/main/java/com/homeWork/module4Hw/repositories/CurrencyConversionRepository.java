package com.homeWork.module4Hw.repositories;

import com.homeWork.module4Hw.entities.CurrencyConversionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversionEntity,Long> {
}
