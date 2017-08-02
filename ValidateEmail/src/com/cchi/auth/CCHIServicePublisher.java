package com.cchi.auth;

import javax.xml.ws.Endpoint;

import com.authentication.ws.HelloWorldImpl;

public class CCHIServicePublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9000/cchi/hello", new CCHIServiceImpl());
		System.out.println("Endpoint Created Successfully!\nGo to http://localhost:9000/cchi/hello?wsdl in browser");
	}
}
