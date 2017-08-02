package com.spade.ws.business;

import java.util.ArrayList;
import java.util.List;

import com.spade.ws.fault.InvalidInputException;
import com.spade.ws.model.Product;


public class ProductServiceImpl {
	
	List<String> bookList = new ArrayList<String>();
	List<String> musicList = new ArrayList<String>();	
	List<String> movieList = new ArrayList<String>();
	
	public ProductServiceImpl () {
		bookList.add("Adultery");
		bookList.add("Inferno");
		bookList.add("And the Mountains Echoed");
		
		musicList.add("Can't remember to forget you");
		musicList.add("mirror");
		musicList.add("despecito");
		
		movieList.add("Lord of the Rings");
		movieList.add("Beast and the Beautiful");
		movieList.add("Hurt locker");		
	}
	
	public List<String> getProductCategories() {
		List<String> list = new ArrayList<String>();
		list.add("Books");
		list.add("Movies");
		list.add("Music");
		return list;		
	}
	
	public List<String> getProducts(String category) throws InvalidInputException {
	
		switch (category) {
		case "Books" 	:	return bookList;
		case "Movies"	:	return movieList;
		case "Music"	:	return musicList;	
		default			:	throw new InvalidInputException("Invalid input", category + " is invalid");
		}	
	}
	
	public boolean addProduct(String category, String product) {
		switch (category) {
		case "Books" 	:	bookList.add(product);	break;
		case "Movies"	:	movieList.add(product);	break;
		case "Music"	:	musicList.add(product);	break;
		default: return false;
		}	
		return true;
	}
	
	public List<Product> getProductCategories1() {
		List<Product> prodcutList = new ArrayList<Product>();
		prodcutList.add(new Product("Javabrains", "2343", 99.99));
		prodcutList.add(new Product("Melhua", "2343", 99.99));
		prodcutList.add(new Product("Melting of the Golden God", "2343", 99.99));
		return prodcutList;		
	}
	
	
}
