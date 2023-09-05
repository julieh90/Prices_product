package com.prices.prices.service;

import com.prices.prices.commons.domains.PricesDTO;
import com.prices.prices.model.entities.Prices;
import com.prices.prices.model.entities.PricesBrand;
import com.prices.prices.repostirory.IPrices;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class PricesManagementTestTwo {


    @Mock
    private IPrices pricesRepository;


    @InjectMocks
    private PricesManagement service;

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void testFindProduct2(Date date, Long product, Long brand) throws ParseException {
        String pattern = "yyyy-MM-dd-HH.mm.ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        Prices expect = Prices.builder()
                .startDate(dateFormat.parse("2020-06-14-00.00.00"))
                .endDate(dateFormat.parse("2020-12-31-23.59.59"))
                .priceList("1")
                .productId(35455L)
                .priority(0)
                .price(35.50)
                .currency("EUR")
                .brand(PricesBrand.builder().id(1L).build())
                .build();
        Prices expect2 = Prices.builder()
                .startDate(dateFormat.parse("2020-06-14-15.00.00"))
                .endDate(dateFormat.parse("2020-06-14-18.30.00"))
                .priceList("2")
                .productId(35455L)
                .priority(1)
                .price(25.45)
                .currency("EUR")
                .brand(PricesBrand.builder().id(1L).build())
                .build();
        Prices expect3 = Prices.builder()
                .startDate(dateFormat.parse("2020-06-15-00.00.00"))
                .endDate(dateFormat.parse("2020-06-15-11.00.00"))
                .priceList("3")
                .productId(35455L)
                .priority(1)
                .price(30.50)
                .currency("EUR")
                .brand(PricesBrand.builder().id(1L).build())
                .build();
        Prices expect4 = Prices.builder()
                .startDate(dateFormat.parse("2020-06-15-16.00.00"))
                .endDate(dateFormat.parse("2020-12-31-23.59.59"))
                .priceList("4")
                .productId(35455L)
                .priority(1)
                .price(38.95)
                .currency("EUR")
                .brand(PricesBrand.builder().id(1L).build())
                .build();

        when(pricesRepository.findProduct(any(), anyLong(), anyLong())).thenReturn(List.of(expect2));
        PricesDTO result = service.findProduct(date, product, brand);

        assertThat(result.getPrice()).isEqualTo(expect2.getPrice());
    }

    private static Stream<Arguments> provideParameters() throws ParseException {

        String pattern = "yyyy-MM-dd-HH.mm.ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        return Stream.of(

                Arguments.of(dateFormat.parse("2020-06-14-16.00.00"), 35455L, 1L)
        );
    }


}

