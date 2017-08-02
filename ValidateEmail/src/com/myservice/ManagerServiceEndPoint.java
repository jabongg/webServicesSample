package com.myservice;

import javax.xml.ws.Endpoint;

public class ManagerServiceEndPoint {

	public static void main(String[] args) {
		
		// Expose the service using an Endpoint import javax.xml.ws.Endpoint;
		//Endpoint endpoint = Endpoint.create(new MangerServiceImpl());
		Endpoint.publish("http://localhost:9002/manager", new MangerServiceImpl());
	}
}
