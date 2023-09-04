package com.prices.prices.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prices")
public class Prices implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "start_date")
    @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    private Date startDate;

    @Column(name = "end_date")
    @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss")
    private Date endDate;

    @Column(name = "price_list")
    private String priceList;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "priority")
    private int priority;

    @Column(name = "price")
    private double price;

    @Column(name = "curr")
    private String currency;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private PricesBrand brand;
}
