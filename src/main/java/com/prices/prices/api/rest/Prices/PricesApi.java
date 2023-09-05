package com.prices.prices.api.rest.Prices;

import com.prices.prices.service.IPricesManagement;
import com.prices.prices.util.UtilsCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/prices/v1")
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequiredArgsConstructor
@Slf4j
public class PricesApi {
    private final IPricesManagement pricesManagement;
    private final UtilsCustom utilsCustom;


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
