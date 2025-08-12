package com.arpanabizpro.arpanabizpro.Service;

import com.arpanabizpro.arpanabizpro.Entity.SoldStockEntity;
import com.arpanabizpro.arpanabizpro.Repository.SoldStockRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface SoldStockService {


    public List<SoldStockEntity> getAllSoldStock();

}
