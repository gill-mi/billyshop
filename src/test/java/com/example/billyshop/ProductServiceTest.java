package com.example.billyshop;

import com.example.billyshop.domain.user.User;
import com.example.billyshop.repository.ProductRepository;
import com.example.billyshop.repository.UserRepository;
import com.example.billyshop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void createTest() {

        userRepository.save(User.builder().name("테스트").build());

    }
}
