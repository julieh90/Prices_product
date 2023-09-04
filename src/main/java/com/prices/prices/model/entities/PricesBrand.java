package com.prices.prices.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brand")
public class PricesBrand implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand_name")
    private String brandName;


}

