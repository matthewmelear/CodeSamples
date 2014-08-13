package com.priceit.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;







import com.priceit.entities.Pricepoint;
import com.priceit.services.parseService.ParseService;
//import com.priceit.dao.PricepointDao;
import com.priceit.services.pricepoint.*;
import com.priceit.utilities.Response;


@Controller
public class PricepointController {

	private PricepointService pricepointService; //bean
	private Response response;
	private ParseService theParseService;
	
	@RequestMapping(value = "viewPricepoints", params = {"id"}, method = RequestMethod.GET)//product id	
	@ResponseBody
	public Response viewPricepoints(@RequestParam(value = "id") String id, HttpServletRequest request) {	
		theParseService = new ParseService();
		long newId = 0;
		try {
			
			newId = theParseService.parseLong(id);
			//newId = Integer.parseInt(id);
			} catch (NumberFormatException nfe){
			//TODO attach improper id format error
			response.setResponse("Unable to parse id");
			return response;
			}
		response = pricepointService.getPricepoints(newId);
		return response;		
	}

	public void setPricepointService(PricepointService pricepointService) {
		this.pricepointService = pricepointService;
	}
	
	public void setResponse(Response response){
		this.response = response;
	}
}


