
package com.priceit.dao;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import com.priceit.entities.Product;
import com.priceit.mapper.ProductMapper;
import com.priceit.utilities.KeyHolderFactory;
import com.priceit.utilities.Response;


@Component
public class ProductDao {

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	
	private ProductMapper productMapper;
	private Response response;
	private Product product;
	private KeyHolderFactory keyHolderFactory;

	GeneratedKeyHolder generatedKeyHolder;

	private static final String ER_PD_001 = "Unable to persist product to database";
	private static final String ER_PD_002 = "Product does not exist in the database";
	private static final String ER_PD_003 = "Could not retrieve this product";
	private static final String SUCCESS = "Success";
	private static final String NAME = "name";
	private static final String DESCRIPTION = "description";
	private static final String CATEGORY = "category";
	private static final String IMAGE = "image";
	private static final String MANUFACTURER_NAME = "manufacturerName";
	private static final String UPC = "upc";

	MapSqlParameterSource args;
	
	public Response getProductByName(String name){
		
		MapSqlParameterSource arguments = new MapSqlParameterSource();
		arguments.addValue("name", name );

		try {
			product = namedJdbcTemplate.queryForObject(Product.GET_PRODUCT,
					arguments, productMapper);

		} catch (Exception e) {
			response.setResponse(ER_PD_003);
		}
		 
		response.setStatusCode(SUCCESS);
		response.setResponse(product);
		return response;
		
	}
	
	
	public Response fuzzyMatch(String name){	
		MapSqlParameterSource args = new MapSqlParameterSource();
		args.addValue(NAME, name);
		List<Product> matchList = new ArrayList<Product>();
		
		try {
			matchList = namedJdbcTemplate.query(Product.GET_FUZZY_MATCH,
					args, productMapper);		
		} catch (Exception e) {
		}
		
		if(matchList.isEmpty()){
			response.setResponse(ER_PD_002);
			return response;
		}
			response.setResponse(matchList);
			response.setStatusCode(SUCCESS);
			return response;
	}

	/**
	 * Find a product by upc or plu
	 * 
	 * @param upc
	 * @return
	 */
	public Response getProductByUpcPlu(String upc){

		MapSqlParameterSource arguments = new MapSqlParameterSource();
		arguments.addValue("upc", upc);	
		try {
			product = namedJdbcTemplate.queryForObject(Product.GET_PRODUCT_BY_UPC,
						arguments, productMapper);
		} catch (Exception e) {
			response.setStatusCode("406");
			response.setResponse(ER_PD_002);
			return response;
		}
		response.setStatusCode(SUCCESS);
		response.setResponse(product);
		return response;
	}




	/**
	 * persists a product object to the database
	 * 
	 * @param product
	 * @return
	 */
	public Response persistProduct(Product product, boolean isUpcNull) {
		args = new MapSqlParameterSource();
		generatedKeyHolder = keyHolderFactory.getKeyHolder();
		args.addValue(NAME, product.getName());
		args.addValue(DESCRIPTION, product.getDescription());
		args.addValue(CATEGORY, product.getCategory());
		args.addValue(IMAGE, product.getImage());
		args.addValue(MANUFACTURER_NAME, product.getManufacturer_name());

		/*
		 * Checks to see if the upc code is null, if it is then pass null, if
		 * not then pass the available upc code
		 */
		if (isUpcNull) {
			args.addValue(UPC, null);

		} else {
			args.addValue(UPC, product.getUpc());
		}

		try {
			namedJdbcTemplate.update(Product.CREATE_PRODUCT, args,
					generatedKeyHolder, new String[] { "id" });
			product.setId(generatedKeyHolder.getKey().longValue());
			response.setStatusCode("200");
			response.setResponse(product);
		} catch (Exception e) {
			response.setStatusCode(e.getMessage());
			response.setResponse(ER_PD_001);
		}
		
		return response;
	}
/**
 * Gets a product by Name for validation
 * @param name
 * @return
 */

	public List<Product> productNameValidation(String name) {
		MapSqlParameterSource args = new MapSqlParameterSource();
		args.addValue(NAME, name);
		List<Product> productList = new ArrayList<Product>();
		try {
	
			productList = namedJdbcTemplate.query(Product.GET_PRODUCT_BY_NAME,
					args, productMapper);
		} catch (Exception e) {

		}
		return productList;
	}
	
	/**
	 * gets a product by UPC for validation
	 * @param upc
	 * @return
	 */
	public List<Product> productUpcValidation(String upc) {
		MapSqlParameterSource args = new MapSqlParameterSource();
		args.addValue(UPC, upc);
		List<Product> productList = new ArrayList<Product>();
		try {
			productList = namedJdbcTemplate.query(Product.GET_PRODUCT_BY_UPC,
					args, productMapper);
		} catch (Exception e) {

		}
		return productList;
	}
	
	
	
	
	
	
	public Response findById(long id) {
		SqlParameterSource args = new MapSqlParameterSource("id", id);
		try {
			System.out.println("in the try");
			response.setResponse(namedJdbcTemplate.queryForObject(
					Product.GET_PRODUCT_BY_ID, args, productMapper));
			System.out.println("after the query");
			response.setStatusCode(SUCCESS);
		} catch (Exception e) {
			response.setStatusCode(ER_PD_002);
		}
		return response;
	}

	public Response getProduct(String name) {

		Product viewProduct = new Product();
		MapSqlParameterSource arguments = new MapSqlParameterSource();
		arguments.addValue("name", name);

		try {
			viewProduct = namedJdbcTemplate.queryForObject(Product.GET_PRODUCT,
					arguments, productMapper);

		} catch (Exception e) {
			response.setResponse(ER_PD_003);
		}

		if (viewProduct.getId() < 1) {
			response.setResponse(ER_PD_002);
		}

		response.setStatusCode(SUCCESS);
		response.setResponse(viewProduct);
		return response;

	}

	/*
	 * setter methods for setter injection and testing
	 */

	public void setKeyHolderFactory(KeyHolderFactory keyHolderFactory) {
		this.keyHolderFactory = keyHolderFactory;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public void setNamedJdbcTemplate(
			NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}

	public void setArgs(MapSqlParameterSource args) {
		this.args = args;
	}

	public void setGeneratedKeyHolder(GeneratedKeyHolder generatedKeyHolder) {
		this.generatedKeyHolder = generatedKeyHolder;
	}


	public ProductMapper getProductMapper() {
		return productMapper;
	}


	public void setProductMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}


	public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
		return namedJdbcTemplate;
	}

	public KeyHolderFactory getKeyHolderFactory() {
		return keyHolderFactory;
	}

	public Response getResponse() {
		return response;
	}

	public GeneratedKeyHolder getGeneratedKeyHolder() {
		return generatedKeyHolder;
	}

	public MapSqlParameterSource getArgs() {
		return args;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


}

