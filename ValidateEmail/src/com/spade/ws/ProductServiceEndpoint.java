package com.spade.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.spade.ws.fault.InvalidInputException;
import com.spade.ws.model.Product;

@WebService (name = "TestMartCatalog")
public interface ProductServiceEndpoint {

	@WebMethod (action = "fetch_categories", operationName = "fetchProductCategories")
	public abstract List<String> getProductCategories();
	
	@WebMethod
	public abstract List<String> getProducts(String category) throws InvalidInputException;
	
	@WebMethod
	public abstract boolean addProduct(String category, String product);
	
	@WebMethod
	@WebResult(name = "Product")
	public abstract List<Product> getProductCategories1();

}