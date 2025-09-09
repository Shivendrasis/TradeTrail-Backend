package com.arpanabizpro.arpanabizpro.Controller;

import com.arpanabizpro.arpanabizpro.Entity.PurchaseEntity;
import com.arpanabizpro.arpanabizpro.Entity.PurchaseItemsEntity;
import com.arpanabizpro.arpanabizpro.Service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    //save method
    @PostMapping("/save")
    public ResponseEntity<PurchaseEntity> save(@RequestBody PurchaseEntity purchase){
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }

    //getAll method
    @GetMapping("/getAll")
    public ResponseEntity<List<PurchaseEntity>> getAllPurchases(){
        return new ResponseEntity<>(purchaseService.getAllPurchases(),HttpStatus.OK);
    }

    //delete by itemCode
    //TODO: Not working properly
    @DeleteMapping("/delete/{itemCode}")
    public ResponseEntity<String> deleteByItemCode(String itemCode){
        return new ResponseEntity<>(purchaseService.deleteItemByItemCode(itemCode), HttpStatus.OK);
    }

    //find by itemcode
    //TODO: Not working properly
    @GetMapping("/get/{itemCode}")
    public ResponseEntity<?> getByItemCode(@PathVariable String itemCode){
          Optional<PurchaseItemsEntity> item = purchaseService.getByItemCode(itemCode);

          if(item.isPresent()){
              return new ResponseEntity<>(item.get(), HttpStatus.OK);
          }else {
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
    }

}
