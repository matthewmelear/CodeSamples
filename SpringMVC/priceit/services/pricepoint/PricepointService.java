package com.priceit.services.pricepoint;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.priceit.dao.PricepointDao;
import com.priceit.entities.Pricepoint;
import com.priceit.entities.Product;
import com.priceit.utilities.Response;

@Service
@Component
public class PricepointService {
	
private PricepointDao pricepointDao;
private Response response; // set bean

public Response getPricepoints(long id) {
	Response response = new Response();
	List<Pricepoint>  listPricepoints = new ArrayList<Pricepoint>();
	
	 if(id < 1 ){
		 response.setResponse("This product does not exist");
	     System.out.println("response " + response);
	     return response;
	 }

	try {
		listPricepoints = pricepointDao.getPricePoint(id);
		//response.setStatusCode("success");
		
	} catch (Exception e) {
	System.out.println( " in e message " + e);
	response.setResponse("Could not retrieve this pricepoint");
	}
	response.setResponse(listPricepoints);
	return response;
}


public void setReponse(Response reponse) {
	this.response = reponse;
}

public void setPricepointDao(PricepointDao pricepointDao) {
	this.pricepointDao = pricepointDao;
}

}





