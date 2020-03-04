package com.pensil.lab.productinfo;

import com.pensil.lab.productinfo.exception.ProductNotFoundException;
import com.pensil.lab.productinfo.model.Product;
import com.pensil.lab.productinfo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Product[]> postProducts(@RequestBody ProductsEvent event) throws ProductNotFoundException {

        ArrayList<Long> productIdList = new ArrayList<>();
        event.getProducts().forEach(p -> productIdList.add(p.getId()));

        ArrayList<Product> products = new ArrayList<>(productService.getProductById(productIdList));
        int resultAmount = products.size();
        if (1 > resultAmount) {
            throw new ProductNotFoundException(productIdList);
        } else {
            return ResponseEntity.ok(products.toArray(new Product[0]));
        }
    }

    @PutMapping(path = "/products", produces = "application/json")
    public ResponseEntity<Product[]> addProducts(@Valid @RequestBody ProductsEvent event) {

        List<Product> result = productService.addProducts(event.getProducts());
        return ResponseEntity.ok(result.toArray(new Product[0]));
    }

}