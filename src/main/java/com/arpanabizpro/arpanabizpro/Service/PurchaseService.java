package com.arpanabizpro.arpanabizpro.Service;

import com.arpanabizpro.arpanabizpro.Entity.PurchaseEntity;
import com.arpanabizpro.arpanabizpro.Entity.PurchaseItemsEntity;

import java.util.List;
import java.util.Optional;

public interface PurchaseService {

    PurchaseEntity save(PurchaseEntity purchase);

    List<PurchaseEntity> getAllPurchases();

    String deleteItemByItemCode(String itemCode);

    Optional<PurchaseItemsEntity> getByItemCode(String itemCode);

}
