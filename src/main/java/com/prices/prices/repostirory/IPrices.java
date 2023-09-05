package com.prices.prices.repostirory;

import com.prices.prices.model.entities.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IPrices extends JpaRepository<Prices, Long> {

    Optional<Prices> findById(Long id);


    @Query("SELECT p FROM Prices p " +
            "WHERE (:startDate IS NULL OR :startDate BETWEEN p.startDate AND p.endDate) " +
            "AND (:productId IS NULL OR p.productId = :productId) " +
            "AND (:brandId IS NULL OR p.brand.id = :brandId) " +
            "ORDER BY (p.priority) DESC ")
    List<Prices> findProduct(
            @Param("startDate") Date applicationDate,
            @Param("productId") Long productId,
            @Param("brandId") Long brandId);

}