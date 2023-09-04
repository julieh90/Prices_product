package com.prices.prices.api.rest.Prices;

import com.prices.prices.service.IPricesManagement;
import com.prices.prices.util.UtilsCustom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/prices/v1")
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@Slf4j
public class PricesApi {
    private final IPricesManagement pricesManagement;
    private final UtilsCustom utilsCustom;

    @Autowired
    public PricesApi(IPricesManagement pricesManagement, UtilsCustom utilsCustom) {
        this.pricesManagement = pricesManagement;
        this.utilsCustom = utilsCustom;
    }

    @GetMapping(value = "/{startDate}/{endDate}", headers = "Accept=application/json")
    public ResponseEntity<?> buscarPorFechas(@PathVariable("startDate") String startDate,
                                             @PathVariable("endDate") String endDate) throws Exception {
        log.info("buscarPorFechas");

        return new ResponseEntity<>(pricesManagement.findByStartDateAndEndDate(utilsCustom.formatDateUtil(startDate),
                utilsCustom.formatDateUtil(endDate)), HttpStatus.OK);
    }

    @GetMapping(value = "/", headers = "Accept=application/json")
    public ResponseEntity<?> buscarProducto(@RequestParam(value = "startDate", required = false) String startDate,
                                            @RequestParam(value = "productId", required = false) Long productId,
                                            @RequestParam(value = "brand_id", required = false) Long brandId)
            throws Exception {


        return new ResponseEntity<>(pricesManagement
                .findProduct(startDate.isEmpty() ? null : utilsCustom.formatDateUtil(startDate), productId, brandId),
                (pricesManagement.findProduct(startDate.isEmpty() ? null : utilsCustom.formatDateUtil(startDate),
                        productId, brandId) == null ? HttpStatus.NO_CONTENT : HttpStatus.OK));
    }

}
