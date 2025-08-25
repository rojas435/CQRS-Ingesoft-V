package com.example.cqrsdemo;

import com.example.cqrsdemo.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TestConfig.class)
class CqrsdemoApplicationTests {

	@Test
	void contextLoads() {
		// Test que verifica que el contexto de Spring se carga correctamente
	}

}
