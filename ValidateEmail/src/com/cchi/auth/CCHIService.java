package com.cchi.auth;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface

@WebService
@SOAPBinding(style=Style.RPC)
public interface CCHIService {
	
	@WebMethod
	String getHelloWorldAsString();
	
	@WebMethod
	String getToken(String companyName, String serviceName, String accessToken);
}
