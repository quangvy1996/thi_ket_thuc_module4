package com.example.ket_thuc_modoule_4.repository;

import com.example.ket_thuc_modoule_4.model.SaleOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SaleOffRepository extends JpaRepository<SaleOff, Long> {
    @Query("SELECT s FROM SaleOff s WHERE s.salePrice = :discount")
    List<SaleOff> findBySalePrice(@Param("discount") double discount);
    @Query("SELECT s FROM SaleOff s WHERE s.startDate >= :startDate AND s.endDate <= :endDate")
    List<SaleOff> findByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
