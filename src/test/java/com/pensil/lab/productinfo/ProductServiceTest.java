package com.pensil.lab.productinfo;

import com.pensil.lab.productinfo.model.Product;
import com.pensil.lab.productinfo.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    @DisplayName("Service test")
    public void addAndFind() {

        Product tesla = new Product(1000l, "Tesla Model 3", 2, 200000.00);
        List<Product> products = new ArrayList<>();
        products.add(tesla);
        productService.addProducts(products);

        List<Long> productIdList = new ArrayList<>();
        productIdList.add(1000l);
        Collection<Product> productFromDbs = productService.getProductById(productIdList);

        Product productFromDb = productFromDbs.iterator().next();

        assertEquals(tesla, productFromDb);
    }
}
