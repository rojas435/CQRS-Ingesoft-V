package com.example.cqrsdemo.config;

import com.example.cqrsdemo.repository.ProductoReadRepository;
import com.example.cqrsdemo.repository.ProductoRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;

@TestConfiguration
public class TestConfig {

    @MockBean
    private ProductoRepository writeRepository;

    @MockBean
    private ProductoReadRepository readRepository;
}
