package com.prices.prices.commons.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prices.prices.model.entities.PricesBrand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PricesDTO implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss",timezone = "GMT-5")
    private Date startDate;
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss",timezone = "GMT-5")
    private Date endDate;
    private Long productId;
    private double price;
    private Long brandId;
}
