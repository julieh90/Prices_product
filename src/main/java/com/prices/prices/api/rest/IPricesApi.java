package com.prices.prices.api.rest;

import com.prices.prices.commons.domains.PricesDTO;

import java.util.Date;

public interface IPricesApi {

    PricesDTO findByStartDateAndEndDate(Date startDate, Date endDate);
}
