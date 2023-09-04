package com.prices.prices.service;

import com.prices.prices.commons.converter.PriceConverter;
import com.prices.prices.commons.domains.ErrorCode;
import com.prices.prices.commons.domains.PricesDTO;
import com.prices.prices.commons.exception.NoContentException;
import com.prices.prices.model.entities.Prices;
import com.prices.prices.repostirory.IPrices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@Slf4j
public class PricesManagement implements IPricesManagement {
    private final IPrices pricesRepository;

    @Autowired
    public PricesManagement(IPrices pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @Override
    public PricesDTO findByStartDateAndEndDate(Date startDate, Date endDate) {
        Optional<Prices> prices = Optional.ofNullable(pricesRepository.findByStartDateAndEndDate(startDate, endDate)
                .orElse(null));


        return PricesDTO.builder()
                .productId(prices.get().getProductId())
                .startDate(prices.get().getStartDate())
                .endDate(prices.get().getEndDate())
                .price(prices.get().getPrice())
                .brandId(prices.get().getBrand().getId())
                .build();

    }

    @Override
    public PricesDTO findProduct(Date startDate, Long productId, Long brandId) {

        List<Prices> products = Optional.ofNullable(pricesRepository.findProduct(startDate, productId, brandId))
                .orElseThrow(() -> new NoContentException(ErrorCode.DATA_NOT_FOUND));
        log.info("Products: {}", products.size());
        Prices productPriority = products.stream()
                .max(Comparator.comparingInt(Prices::getPriority))
                .orElse(null);

        return PriceConverter.convertPriceToPriceDTO(productPriority);

    }
}

