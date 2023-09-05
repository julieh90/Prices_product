package com.prices.prices.service;

import com.prices.prices.commons.domains.PricesDTO;

import java.util.Date;


public interface IPricesManagement {

    PricesDTO findProduct(Date startDate, Long productId, Long brandId) throws Exception;


}
