package com.rainhard.product.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rainhard.product.service.dto.request.ProductRequestDto;
import com.rainhard.product.service.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProductServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ProductRepository productRepository;

	@Test
	void createProduct() throws Exception {
		var productRequest = productRequest();
		String productRequestString = objectMapper.writeValueAsString(productRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/product/save")
						.contentType(MediaType.APPLICATION_JSON)
						.content(productRequestString)).andExpect(MvcResult::getRequest);
		Assertions.assertEquals(1, productRepository.findAll().size());
	}

	private ProductRequestDto productRequest(){
		var productRequest = new ProductRequestDto();
		productRequest.setName("Product one");
		productRequest.setDescription("Desc one");
		productRequest.setPrice(220000);
		return productRequest;
	}


	@Test
	void contextLoads() {
	}

}
