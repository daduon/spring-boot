package com.example.springcrud.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.springcrud.entity.Product;

@Service
public interface ProductService {
    // list products
    List<Product> listProdcts();

    // save product
    Product saveProduct(Product product);

    // update product
    Product updateProduct(Product product,Long id);

    // delete product
    void deleteProduct(Long productId);


}
