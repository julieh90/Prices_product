package com.prices.prices.repostirory.prices;

import com.prices.prices.repostirory.IPrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PricesImp  {

    @Autowired
    private IPrices repository;


}
