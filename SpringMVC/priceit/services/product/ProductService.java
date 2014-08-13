package com.priceit.services.product;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.priceit.dao.ProductDao;
import com.priceit.entities.Product;
import com.priceit.services.parseService.ParseService;
import com.priceit.utilities.Response;
import com.priceit.utilities.Utilities;

@Service
public class ProductService {
	private Response response;
	private Product product;
	private Utilities utilities;
	private ProductDao productDao;

	private static final String ER_PS_002 = "UPC Code is an invalid format";
	private static final String ER_PS_003 = "This product already exists.";
	private static final String ER_PS_004 = "Invalid id";
	private static final String ER_PS_005 = "Could not persist image.";
	private static final String ER_PS_006 = "Could not validate product.";
	private static final String ER_PS_008 = "Invalid name, description or upc.";
	private ArrayList<String> errorList;
	private boolean isUpcNull = false;
	
	private ParseService parseService;
	
	

	
	/**
	 * Creates a product with an image
	 * @param request
	 * @param servletResponse
	 * @return
	 */
	public Response createProductWithImage(
			MultipartHttpServletRequest multiRequest,
			HttpServletRequest request, HttpServletResponse servletResponse) {
		errorList = new ArrayList<String>();
		String name;
		String description;
		String upc;
		String category;
		String manufacturer;
		String image = "";

		if (servletResponse != null) {

			name = multiRequest.getParameter("productName");
			description = multiRequest.getParameter("description");
			upc = multiRequest.getParameter("upc");
			category = multiRequest.getParameter("productType");
			manufacturer = multiRequest.getParameter("manufacturer");

		} else {
			name = request.getParameter("productName");
			description = request.getParameter("description");
			upc = request.getParameter("upc");
			category = request.getParameter("productType");
			manufacturer = request.getParameter("manufacturer");
		}

		// null checks
		if (!utilities.isNullOrEmpty(name)
				&& !utilities.isNullOrEmpty(description)) {
			// validates the upc and name
			if (validationCheck(upc) && !checkForDuplicates(name, upc)) {

				// checks to see if an image needs to be uploaded
				if (servletResponse != null) {
					image = uploadImage(multiRequest);
				}
				response = createProduct(name, description, upc, category,
						image, manufacturer);
			}
		} else {
			errorList.add(ER_PS_008);
			response.setStatusCode("500");
			response.setResponse(errorList);
		}

		return response;

	}
	
	
/**
 * takes a multipart request and stores the uploaded file in an upload folder, returns a string with the image path
 * @param request
 * @return
 */
	public String uploadImage(MultipartHttpServletRequest request) {
		String upc = request.getParameter("upc");
		String image = "";
		InputStream inputStream = null;
		OutputStream outputStream = null;
		Iterator<String> itr = request.getFileNames();

		try {
			MultipartFile mpf = request.getFile(itr.next());
			inputStream = mpf.getInputStream();

			File newFile = new File("../PriceIT/uploads/" + upc
					+ mpf.getOriginalFilename());
			image = newFile.getPath();
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			errorList.add(ER_PS_005);
		}
		return image;
	}
	




	/**
	 * takes the product paramteres and sets them to the product object and
	 * sends the object to the dao for persisting
	 * 
	 * @return
	 */
	public Response createProduct(String name, String description, String upc,
			String category, String image, String manufacturer_name) {
		if (!isUpcNull) {
			product.setUpc(upc);
		} else {
			product.setUpc("");
		}
		product.setName(name);
		product.setDescription(description);
		product.setCategory(category);
		product.setManufacturer_name(manufacturer_name);
		product.setImage(image);
		response = productDao.persistProduct(product, isUpcNull);

		return response;
	}

	/**
	 * Uses a utility method to check if upc is a number or null
	 * 
	 * @param upc
	 * @param manufacturer_id
	 * @return
	 */
	public boolean validationCheck(String upc) {
		boolean validationOk = true;
		if (!(utilities.isNullOrEmpty(upc))) {
			if (!(utilities.checkIfNumber(upc))) {
				errorList.add(ER_PS_002);
				response.setStatusCode("500");
				validationOk = false;
				response.setResponse(errorList);
			} else {

			}
		} else {
			isUpcNull = true;

		}
		return validationOk;
	}
	
/**
 * Searches for a product and returns a list of the 10 closest product matches
 * Three char match minimum
 * @param
 * @return
 */
	public Response fuzzyMatch(String nameOrUpc) {

		long upcCode= parseService.parseLong(nameOrUpc);
		if(upcCode > 0){
			response = productDao.getProductByUpcPlu(nameOrUpc);
			return response;  
		}			
		if(nameOrUpc.length() < 3){
			response.setResponse(ER_PS_006);
			return response;
		}		
		String lowerName =  "%" + nameOrUpc.toLowerCase() + "%" ;  //append % for wildcard in query
		try {
			response = productDao.fuzzyMatch(lowerName);
		} catch (Exception e) {
			response.setResponse(ER_PS_005);
		}
		return response;
	}
	

	/**
	 * Checks for a duplicate product name in the database
	 * 
	 * @param name
	 * @return
	 */
	public boolean checkForDuplicates(String name, String upc) {
		boolean isDuplicateProduct = false;
		List<Product> productList = new ArrayList<Product>();
		List<Product> upcList = new ArrayList<Product>();

		try {
			productList = productDao.productNameValidation(name);
			upcList = productDao.productUpcValidation(upc);
		} catch (Exception e) {
			errorList.add(ER_PS_006);
			response.setStatusCode("500");
		}
		if (productList.size() > 0 || upcList.size() > 0) {
			isDuplicateProduct = true;
			errorList.add(ER_PS_003);
			response.setStatusCode("500");
			response.setResponse(errorList);
		}

		return isDuplicateProduct;
	}

	public Response findById(String unparsedId) {

		// TODO bean out errorList
		ArrayList<String> errorList = new ArrayList<String>();
		long id = 0;

		try {
			id = Long.parseLong(unparsedId);
		} catch (NumberFormatException nfe) {

		}
		// TODO eliminate the double return
		// TODO abstract out parser
		if (id > 0) {
			response = productDao.findById(id);
		} else {
			errorList.add(ER_PS_004);
			Response temp = new Response();
			temp.setResponse(errorList);
			temp.setStatusCode("406");
			return temp;
		}
		return response;
	}


	public Response getProductByName(String name) {

		try {
			response = productDao.getProduct(name);

		} catch (Exception e) {
			System.out.println(" in e message " + e);
			response.setResponse("Could not retrieve product");
		}

		return response;

	}

	public Response getProduct(String ident) { // get product by upc or plu
		String upcPlu = ident;
		if (!(upcPlu).equals(null)) {
			try {
				response = productDao.getProductByUpcPlu(upcPlu);
			} catch (Exception e) {
			}
		}
		return response;
	}
			
			
	
	/*
	 * setters for setter injection and testing
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	public void setUtilities(Utilities utilities) {
		this.utilities = utilities;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public void setErrorList(ArrayList<String> errorList) {
		this.errorList = errorList;
	}

	








public Response viewProduct(String name) {  //get product by name
	try {
		response = productDao.getProduct(name);
	} catch (Exception e) {
		response.setResponse(ER_PS_005);
	}
	return response;
}


public void setParseService(ParseService parseService) {
	this.parseService = parseService;
}
}
