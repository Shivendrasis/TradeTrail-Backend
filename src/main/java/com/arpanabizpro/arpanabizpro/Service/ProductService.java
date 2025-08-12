package com.arpanabizpro.arpanabizpro.Service;

import com.arpanabizpro.arpanabizpro.Entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductEntity addStock(ProductEntity productEntity);

    Optional<ProductEntity> getStockByItemCode(String itemCode);

    List<ProductEntity> getAllProducts();

    ProductEntity delete(String itemCode);
}


