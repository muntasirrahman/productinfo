package com.pensil.lab.productinfo;

import com.pensil.lab.productinfo.model.Product;
import com.pensil.lab.productinfo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void addAndFind() {

        Product tesla = new Product(0, "Tesla Model 3", 1, 120000.00);
        entityManager.persist(tesla);
        entityManager.flush();

        List<Long> productIdList = new ArrayList<>();
        productIdList.add(0l);
        List<Product> products = repository.findByIdIn(productIdList);
        Product productFromDb = products.get(0);

        assertThat(tesla).isEqualTo(productFromDb);
    }
}
