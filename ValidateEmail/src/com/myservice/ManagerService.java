package com.myservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.RPC)
public interface ManagerService {

	/*@WebMethod 
	public Manager getManagerDetails();
*/	
	@WebMethod 
	String getHelloWorldAsString(String name);
}
