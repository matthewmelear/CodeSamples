package com.priceit.services.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.priceit.dao.StoreDao;
import com.priceit.entities.Store;

@Service
@Component
public class ReadStoreService {

	@Autowired
	StoreDao storeDao;
	
	public List<Store> getAllStores() {
		return storeDao.getAllStores();	
	}

	public Store getStoreById(String id) {
		int newId = 0;
		Store store = null;
		try {
			newId = Integer.parseInt(id);
		} catch (NumberFormatException nfe){
			//TODO attach improper id format error
			System.out.println("unable to parse id");
		}
		if (newId != 0){
			store = storeDao.getStoreById(newId);
		}
		return store;
	}
	
}