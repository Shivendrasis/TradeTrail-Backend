package com.arpanabizpro.arpanabizpro.Controller;


import com.arpanabizpro.arpanabizpro.Entity.ProductEntity;
import com.arpanabizpro.arpanabizpro.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {


    @Autowired
    private ProductService productService;

    //add method
    @PostMapping("/add")
    public ProductEntity addStock(@RequestBody ProductEntity productEntity){
        return productService.addStock(productEntity);
    }

    //get by itemCode
    @GetMapping("/get/{itemCode}")
    public ProductEntity getStockByItemCode(@PathVariable String itemCode){
        return productService.getStockByItemCode(itemCode)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    //getAll method
    @GetMapping("/all")
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    //delete by itemCode
    @DeleteMapping("/delete/{itemCode}")
    public ProductEntity delete(@PathVariable String itemCode){
        return productService.delete(itemCode);
    }


}
