package com.priceit.services.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.priceit.dao.StoreDao;
import com.priceit.entities.Store;

@Service
@Component
public class UpdateStoreService {

	@Autowired
	StoreDao storeDao;
	
	public void serviceMethod(String id, String name, String street, String city, String state, String zip) {
		Store store = new Store();
		store.setName(name);
		store.setStreet(street);
		store.setCity(city);
		store.setState(state);
		try {
			int newZip = Integer.parseInt(zip);
			store.setZip(newZip);
		} catch (NumberFormatException nfe){
			//TODO:add parse zip error
			System.out.println("unable to parse zip");
		}
		storeDao.updateStore(store);
	}

}
