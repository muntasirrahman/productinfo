package com.pensil.lab.productinfo;

import com.pensil.lab.productinfo.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Objects;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @LocalServerPort
    protected int serverPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void queryProducts() throws Exception {

        Product product1 = new Product(5, "ChromeBook", 1,1211.00);
        Product product2 = new Product(6, "SurfacePro", 1,1878.00);

        ProductsEvent addRequest = new ProductsEvent();
        addRequest.addProduct(product1);
        addRequest.addProduct(product2);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ProductsEvent> requestEntity = new HttpEntity<>(addRequest, headers);

        ResponseEntity<Product[]> addProductRespEntity = restTemplate
                .withBasicAuth("admin", "admin1234")
                .exchange("/api/products", HttpMethod.PUT, requestEntity, Product[].class);
        assertEquals("Adding new product result", HttpStatus.OK, addProductRespEntity.getStatusCode());

        ProductsEvent queryRequest = new ProductsEvent();
        queryRequest.addProduct(new Product(5));
        queryRequest.addProduct(new Product(6));

        ResponseEntity<Product[]> queryRespEntity = restTemplate
                .withBasicAuth("user", "user1234")
                .postForEntity("/api/products", queryRequest, Product[].class);

        System.out.println("Response: " + queryRespEntity.getBody());
        assertEquals("Querying product result", HttpStatus.OK, queryRespEntity.getStatusCode());

        Product resultProduct = Objects.requireNonNull(queryRespEntity.getBody())[0];
        assertEquals("Query Result: ", product1, resultProduct);
    }
}