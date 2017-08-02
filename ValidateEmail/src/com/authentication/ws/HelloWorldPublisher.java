package com.authentication.ws;

import javax.xml.ws.Endpoint;

public class HelloWorldPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
		System.out.println("Endpoint Created Successfully!\nGo to http://localhost:9999/ws/hello?wsdl in browser");
	}
}
