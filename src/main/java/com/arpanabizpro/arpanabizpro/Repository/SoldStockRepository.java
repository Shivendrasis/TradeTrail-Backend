package com.arpanabizpro.arpanabizpro.Repository;


import com.arpanabizpro.arpanabizpro.Entity.SoldStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldStockRepository extends JpaRepository<SoldStockEntity, Long> {

}
