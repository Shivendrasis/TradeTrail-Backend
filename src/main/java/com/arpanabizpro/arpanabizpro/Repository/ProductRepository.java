package com.arpanabizpro.arpanabizpro.Repository;

import com.arpanabizpro.arpanabizpro.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    //method to find by itemCode
    Optional<ProductEntity> findByItemCode(String itemCode);

}
