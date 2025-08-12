package com.arpanabizpro.arpanabizpro.Service.ProductServiceImpl;

import com.arpanabizpro.arpanabizpro.Entity.PurchaseEntity;
import com.arpanabizpro.arpanabizpro.Entity.PurchaseItemsEntity;
import com.arpanabizpro.arpanabizpro.Repository.PurchaseItemsRepository;
import com.arpanabizpro.arpanabizpro.Repository.PurchaseRepository;
import com.arpanabizpro.arpanabizpro.Service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImplimentation implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private PurchaseItemsRepository purchaseItemsRepository;

    @Override
    public PurchaseEntity save(PurchaseEntity purchase) {
        for(PurchaseItemsEntity items: purchase.getItems()){
            items.setPurchase(purchase);
        }
        return purchaseRepository.save(purchase);
    }

    @Override
    public List<PurchaseEntity> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    @Override
    public String deleteItemByItemCode(String itemCode) {
        Optional<PurchaseItemsEntity> item = purchaseItemsRepository.findByItemCode(itemCode);

        if(item.isPresent()){
            purchaseItemsRepository.deleteByItemCode(itemCode);
            return "Item with code " + itemCode + " deleted successfully.";
        }else {
            return "Item with code " + itemCode + " not found.";
        }
    }

    @Override
    public Optional<PurchaseItemsEntity> getByItemCode(String itemCode) {
        return purchaseItemsRepository.findByItemCode(itemCode);
    }


}
