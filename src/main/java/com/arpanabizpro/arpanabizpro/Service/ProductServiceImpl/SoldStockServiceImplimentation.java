package com.arpanabizpro.arpanabizpro.Service.ProductServiceImpl;


import com.arpanabizpro.arpanabizpro.Entity.SoldStockEntity;
import com.arpanabizpro.arpanabizpro.Repository.SoldStockRepository;
import com.arpanabizpro.arpanabizpro.Service.SoldStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldStockServiceImplimentation implements SoldStockService {

    @Autowired
    private SoldStockRepository soldStockRepository;

    @Override
    public List<SoldStockEntity> getAllSoldStock() {
        return soldStockRepository.findAll();
    }
}
