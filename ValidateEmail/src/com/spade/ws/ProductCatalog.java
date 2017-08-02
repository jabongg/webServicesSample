package com.spade.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.spade.ws.business.ProductServiceImpl;
import com.spade.ws.fault.InvalidInputException;
import com.spade.ws.model.Product;

@WebService(endpointInterface = "com.spade.ws.ProductServiceEndpoint", portName = "TestMartCatalogPort", 
serviceName = "TestMartCatalogService", targetNamespace = "http://www.writealone.com")
public class ProductCatalog implements ProductServiceEndpoint {
	
	ProductServiceImpl productService = new ProductServiceImpl();
	
	/* (non-Javadoc)
	 * @see com.spade.ws.ProductServiceEndpoint#getProductCategories()
	 */
	@Override
	public List<String> getProductCategories() {
		return productService.getProductCategories();
	}
	
	/* (non-Javadoc)
	 * @see com.spade.ws.ProductServiceEndpoint#getProducts(java.lang.String)
	 */
	@Override
	public List<String> getProducts(String category) throws InvalidInputException {
		return productService.getProducts(category);
	}
	
	/* (non-Javadoc)
	 * @see com.spade.ws.ProductServiceEndpoint#addProduct(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addProduct(String category, String product) {
		return productService.addProduct(category, product);
	}
	
	/* (non-Javadoc)
	 * @see com.spade.ws.ProductServiceEndpoint#getProductCategories1()
	 */
	@Override
	public List<Product> getProductCategories1() {
		return productService.getProductCategories1();
	}	
}
