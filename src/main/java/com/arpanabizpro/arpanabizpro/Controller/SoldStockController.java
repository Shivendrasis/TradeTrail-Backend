package com.arpanabizpro.arpanabizpro.Controller;

import com.arpanabizpro.arpanabizpro.Entity.SoldStockEntity;
import com.arpanabizpro.arpanabizpro.Repository.SoldStockRepository;
import com.arpanabizpro.arpanabizpro.Service.SoldStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/Stock")
@RestController
public class SoldStockController {


    @Autowired
    private SoldStockService soldStockService;

    @Autowired
    private SoldStockRepository soldStockRepository;

    //get all sold stock
    @GetMapping("/soldStock")
    public List<SoldStockEntity> getAllSoldStock(){
        return soldStockService.getAllSoldStock();
    }


    //addSold stock
    @PostMapping("/sell")
    public SoldStockEntity addSoldStock(@RequestBody SoldStockEntity soldStockEntity) {
        return soldStockRepository.save(soldStockEntity);
    }

}
