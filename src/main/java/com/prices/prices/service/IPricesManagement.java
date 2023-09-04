package com.prices.prices.service;

import com.prices.prices.commons.domains.PricesDTO;

import java.util.Date;
import java.util.List;


public interface IPricesManagement {

    PricesDTO findByStartDateAndEndDate(Date startDate, Date endDate) throws Exception;
    PricesDTO findProduct (Date startDate, Long productId, Long brandId) throws Exception;


}
