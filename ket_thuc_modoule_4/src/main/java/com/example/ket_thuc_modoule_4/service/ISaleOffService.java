package com.example.ket_thuc_modoule_4.service;

import com.example.ket_thuc_modoule_4.model.SaleOff;


import java.time.LocalDate;
import java.util.List;

public interface ISaleOffService {
    List<SaleOff> getAllSaleOff();
    SaleOff createSaleOff(SaleOff saleoff);
    SaleOff getSaleOffById(Long id);
    void deleteSaleOffById(Long id);
    void saveSaleOff(SaleOff saleOff);
    List<SaleOff> findByDiscount(double discount);
    List<SaleOff> findByDateRange(LocalDate startDate, LocalDate endDate);
}
