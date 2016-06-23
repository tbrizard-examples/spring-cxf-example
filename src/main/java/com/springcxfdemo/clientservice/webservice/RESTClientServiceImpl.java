package com.springcxfdemo.clientservice.webservice;

import com.springcxfdemo.clientservice.business.model.Client;
import com.springcxfdemo.clientservice.business.service.ClientService;
import com.springcxfdemo.clientservice.webservice.resources.ClientResource;

/**
 *
 */
public class RESTClientServiceImpl implements RESTClientService {

	// we'll use old school XML bean wiring in this example instead of using component scanning
	private ClientService service; 
	
	@Override
	public ClientResource findClient(String clientId) {
		
		// really simple implementation just to show that this class gets called
		// for the correct request mapping
		Client client = service.findClient(clientId);
		
		if (client != null) {
			ClientResource res = new ClientResource(client.getId(), client.getLastName(), client.getFirstName());
			return res;
		}
		
		return null;
	}

	public void setService(ClientService service) {
		this.service = service;
	}	
}
