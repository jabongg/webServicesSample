package com.spade.ws;

import javax.xml.ws.Endpoint;

public class ProductCatalogPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9000/ws/productcatalog", new ProductCatalog());
		System.out.println("Product Catalog Endpoint created Successfully!");
	}
}
