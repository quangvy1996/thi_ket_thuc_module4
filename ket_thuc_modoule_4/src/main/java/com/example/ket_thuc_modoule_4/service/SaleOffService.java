package com.example.ket_thuc_modoule_4.service;

import com.example.ket_thuc_modoule_4.model.SaleOff;
import com.example.ket_thuc_modoule_4.repository.SaleOffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleOffService implements ISaleOffService {
    @Autowired
    SaleOffRepository saleOffRepository;

    public List<SaleOff> getAllSaleOff() {
        return saleOffRepository.findAll();
    }
    public SaleOff createSaleOff(SaleOff saleoff){
        return saleOffRepository.save(saleoff);
    }

    public SaleOff getSaleOffById(Long id) {
        return saleOffRepository.findById(id).orElse(null);
    }

    public void deleteSaleOffById(Long id) {
        saleOffRepository.deleteById(id);
    }

    public void saveSaleOff(SaleOff saleOff) {
        saleOffRepository.save(saleOff);
    }
    public List<SaleOff> findByDiscount(double discount) {
        return saleOffRepository.findBySalePrice(discount);
    }

    public List<SaleOff> findByDateRange(LocalDate startDate, LocalDate endDate) {
        return saleOffRepository.findByDateRange(startDate, endDate);
    }
}
