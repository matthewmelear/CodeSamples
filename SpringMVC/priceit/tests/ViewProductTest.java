package com.priceit.tests;


import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.priceit.dao.ProductDao;
import com.priceit.entities.Product;
import com.priceit.services.product.ProductService;
import com.priceit.utilities.Response;

@RunWith(MockitoJUnitRunner.class)
public class ViewProductTest {
	
	private Product product;
	private Product tempProduct;
	private Response response;
	private Response actualResponse;
	
	@Mock
	private ProductDao productDao;
	
	@InjectMocks
	private ProductService productService = new ProductService();
	

	@Before
	public void setUp() throws Exception {
		product = new Product();
		product.setName("Twix");
		
		tempProduct = new Product();
	
		response = new Response();
		response.setResponse(product);
		response.setStatusCode("OK");
		
		actualResponse = new Response();
		
	}
	
	@Test
	public final void testViewProductByName() throws Exception{
		when(productDao.getProduct(Matchers.anyString())).thenReturn(response);
		actualResponse = productService.getProduct("Twix");
		tempProduct = (Product) actualResponse.getResponse();
		assertEquals(product.getName(), tempProduct.getName());
	}
	
	
	

}
