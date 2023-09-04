package com.prices.prices.commons.converter;

import com.prices.prices.commons.domains.PricesDTO;
import com.prices.prices.model.entities.Prices;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PriceConverter {

    public static PricesDTO convertPriceToPriceDTO(Prices prices) {
        try {

            return PricesDTO.builder()
                    .productId(prices.getProductId())
                    .startDate(prices.getStartDate())
                    .endDate(prices.getEndDate())
                    .price(prices.getPrice())
                    .brandId(prices.getBrand().getId())
                    .build();

        } catch (Exception e) {
            log.info("Error convert price to PriceDTO: " + e.getMessage());
            return null;
        }
    }
}
