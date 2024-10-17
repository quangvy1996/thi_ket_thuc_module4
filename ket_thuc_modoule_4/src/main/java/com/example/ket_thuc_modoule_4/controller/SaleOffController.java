package com.example.ket_thuc_modoule_4.controller;

import com.example.ket_thuc_modoule_4.model.SaleOff;
import com.example.ket_thuc_modoule_4.service.ISaleOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/saleoff")
public class SaleOffController {

    @Autowired
    private ISaleOffService saleOffService;

    @GetMapping
    public String listSaleOffs(Model model) {
        model.addAttribute("saleOffList", saleOffService.getAllSaleOff());
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("saleoff", new SaleOff());
        return "add";
    }

    @PostMapping("/add")
    public String addSaleOff(@ModelAttribute("saleoff") SaleOff saleOff) {
        saleOffService.createSaleOff(saleOff);
        return "redirect:/saleoff";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        SaleOff saleOff = saleOffService.getSaleOffById(id);
        model.addAttribute("saleoff", saleOff);
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteSaleOff(@PathVariable("id") Long id) {
        saleOffService.deleteSaleOffById(id);
        return "redirect:/saleoff";
    }

    @GetMapping("/search")
    public String searchSaleOffs(@RequestParam("discount") Optional<Double> discount, Model model) {
        List<SaleOff> saleOffList;
        System.out.println(discount);
        if (discount.isPresent()) {
            saleOffList = saleOffService.findByDiscount(discount.get());
        } else {
            saleOffList = saleOffService.getAllSaleOff();
        }
        model.addAttribute("saleOffList", saleOffList);
        return "list";
    }

    @GetMapping("/search-day")
    public String searchByDate(
            @RequestParam("startDateStr") LocalDate startDate,
            @RequestParam("endDateStr") LocalDate endDate,
            Model model) {
        List<SaleOff> saleOffList = saleOffService.findByDateRange(startDate, endDate);
        model.addAttribute("saleOffList", saleOffList);
        return "list";
    }

}
