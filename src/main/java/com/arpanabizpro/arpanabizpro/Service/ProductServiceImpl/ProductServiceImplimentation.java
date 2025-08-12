package com.arpanabizpro.arpanabizpro.Service.ProductServiceImpl;

import com.arpanabizpro.arpanabizpro.Entity.ProductEntity;
import com.arpanabizpro.arpanabizpro.Repository.ProductRepository;
import com.arpanabizpro.arpanabizpro.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplimentation implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity addStock(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public Optional<ProductEntity> getStockByItemCode(String itemCode) {
        return productRepository.findByItemCode(itemCode);
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity delete(String itemCode) {

        ProductEntity product = productRepository.findByItemCode(itemCode)
                .orElseThrow( ()-> new RuntimeException("Product not found with this itemCode: " + itemCode));

        productRepository.delete(product);
        return product;
    }

}
