package com.priceit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.priceit.entities.Store;
import com.priceit.services.store.CreateStoreService;
import com.priceit.services.store.DeleteStoreService;
import com.priceit.services.store.ReadStoreService;
import com.priceit.services.store.UpdateStoreService;

@Controller
public class StoreController {


	
	private CreateStoreService createStoreService;
	private UpdateStoreService updateStoreService;
	private DeleteStoreService deleteStoreService;
	private ReadStoreService readStoreService;
	
	@RequestMapping(value = "store/create", params = { "name", "street", "city", "state", "zip" }, method = RequestMethod.POST)
	@ResponseBody
	public void createStore(@RequestParam(value = "name") String name,
							@RequestParam(value = "street") String street,
							@RequestParam(value = "city") String city,
							@RequestParam(value = "state") String state,
							@RequestParam(value = "zip") String zip) {
		createStoreService.serviceMethod(name, street, city, state, zip);
	}
	
	@RequestMapping(value = "store/{id}", params = { "name", "street", "city", "state", "zip" }, method = RequestMethod.POST)
	@ResponseBody
	public void updateStore(@PathVariable(value = "id") String id,
							@RequestParam(value = "name") String name,
							@RequestParam(value = "street") String street,
							@RequestParam(value = "city") String city,
							@RequestParam(value = "state") String state,
							@RequestParam(value = "zip") String zip) {
		updateStoreService.serviceMethod(id, name, street, city, state, zip);
	}
	
	@RequestMapping(value = "store/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteStore(@PathVariable(value = "id") String id){
		deleteStoreService.serviceMethod(id);
	}
	
	@RequestMapping(value = "store", method = RequestMethod.GET)
	@ResponseBody
	public void getAllStores(){
		List<Store> allStores = readStoreService.getAllStores();
	}
	
	@RequestMapping(value = "store/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void getStoreById(@PathVariable(value = "id") String id){
		Store store = readStoreService.getStoreById(id);
	}
	
}
