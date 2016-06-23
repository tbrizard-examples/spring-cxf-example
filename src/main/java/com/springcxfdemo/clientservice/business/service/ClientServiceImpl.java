package com.springcxfdemo.clientservice.business.service;

import com.springcxfdemo.clientservice.business.model.Client;

/**
 *
 */
public class ClientServiceImpl implements ClientService {

	public Client findClient(String clientId) {
		
		// incredibly fake code here just to illustrate that this class gets called
		if ("1".equalsIgnoreCase(clientId)) {
			return new Client("1", "Wiggins", "Bob");
		}
		
		return null;
	}
}
