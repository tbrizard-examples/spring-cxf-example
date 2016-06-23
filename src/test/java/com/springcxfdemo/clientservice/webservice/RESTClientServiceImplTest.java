package com.springcxfdemo.clientservice.webservice;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.springcxfdemo.clientservice.business.model.Client;
import com.springcxfdemo.clientservice.business.service.ClientService;
import com.springcxfdemo.clientservice.webservice.resources.ClientResource;

/**
 * 
 */
public class RESTClientServiceImplTest {
	
	private RESTClientService service;
	private ClientService mockClientService; // I would usually use IMockControl here, but keeping this simple
		
	@Before
	public void setUp() {
	
		service = new RESTClientServiceImpl();
		mockClientService = EasyMock.createMock(ClientService.class);		
		((RESTClientServiceImpl)service).setService(mockClientService);
	}
	
	@Test
	public void testFindClientWithValidID() {
	
		Client client = new Client("1", "Rocket", "Johny");
		expect(mockClientService.findClient("1")).andReturn(client);	
		replay(mockClientService);
		
		ClientResource actual = service.findClient("1");
		verify(mockClientService);
		
		assertNotNull(actual);
		assertThat(actual.getId(), is("1"));
		assertThat(actual.getLastName(), is("Rocket"));
		assertThat(actual.getFirstName(), is("Johny"));
	}
	
	@Test
	public void testFindClientWithInvalidID() {
	
		expect(mockClientService.findClient("2")).andReturn(null);	
		replay(mockClientService);
		
		ClientResource actual = service.findClient("2");
		verify(mockClientService);
		
		assertNull(actual);
	}
	
	@Test
	public void testFindClientWithNullID() {
	
		expect(mockClientService.findClient(null)).andReturn(null);	
		replay(mockClientService);
		
		ClientResource actual = service.findClient(null);
		verify(mockClientService);
		
		assertNull(actual);
	}
}
