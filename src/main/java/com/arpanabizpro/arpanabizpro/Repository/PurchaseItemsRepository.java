package com.arpanabizpro.arpanabizpro.Repository;

import com.arpanabizpro.arpanabizpro.Entity.PurchaseItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurchaseItemsRepository extends JpaRepository<PurchaseItemsEntity, Long> {

    void deleteByItemCode(String itemCode);

    Optional<PurchaseItemsEntity> findByItemCode(String itemCode);
}
