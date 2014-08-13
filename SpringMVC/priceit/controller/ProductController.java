package com.priceit.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.priceit.services.product.ProductService;
import com.priceit.utilities.Response;


@Controller
public class ProductController {




	
	private ProductService productService; //bean ref 
	private Response response;  //don't autowire this 
	
	@RequestMapping(value = "perfectMatch", params = {"ident"}, method = RequestMethod.GET)//ident= upc or plu or exact name
	@ResponseBody
	public Response perfectMatch(@RequestParam(value = "ident") String ident, HttpServletRequest request) { //ident comes in as string
		response = productService.getProduct(ident);
		return response;
	}
	
	@RequestMapping(value = "fuzzyMatch", params = {"name"}, method = RequestMethod.GET)//name fuzzy name or upc
	@ResponseBody
	public Response fuzzyMatch(@RequestParam(value = "name") String name, HttpServletRequest request) { //name comes in as string
		response = productService.fuzzyMatch(name);
		return response;
	}
	


	@RequestMapping(value = "viewProduct", params = {"name"}, method = RequestMethod.GET)
	@ResponseBody
	public Object viewProduct(@RequestParam(value = "name") String name, HttpServletRequest request) {	
		return productService.viewProduct(name);		
	}
	
	@RequestMapping(value = "product/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Response viewProductById(@PathVariable(value = "id") String id, HttpServletRequest request) {
		response = productService.findById(id);
		return response;		
	}



	/**
	 * creates a product with an image
	 * @param multiRequest
	 * @param servletResponse
	 * @return
	 */

	@RequestMapping(value = "/createWithImage", method = RequestMethod.POST)
	   public @ResponseBody Response upload(MultipartHttpServletRequest multiRequest, HttpServletResponse servletResponse) { 
		
		response = productService.createProductWithImage(multiRequest, null, servletResponse);
		

	 return response;
	  }
	
	
	
/**
 * Controller method that calls the service for creating a product without an image
 * @param request
 * @return
 */
	
	@RequestMapping(value="/createWithoutImage", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody Response createProduct(HttpServletRequest request){
		
	
		response = productService.createProductWithImage(null, request, null);
		
		return response;
	}
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public Response getResponse() {
		return response;
	}


	public void setResponse(Response response) {
		this.response = response;
	}


}

