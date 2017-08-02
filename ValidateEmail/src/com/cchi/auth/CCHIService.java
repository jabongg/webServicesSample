package com.cchi.auth;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface

@WebService
@SOAPBinding(style=Style.DOCUMENT)
public interface CCHIService {
	
	@WebMethod
	public abstract String getHelloWorldAsString();
	
	@WebMethod
	public abstract String getToken(String companyName, String serviceName, String accessToken);
	
	@WebMethod
	public abstract List<Beneficiary> getBeneficiaryDetails(String  visaNumber, String passportNumber);
	
	@WebMethod
	public abstract boolean addBeneficiary(String visaNumber, String passportNumber,
			String name, String email);
}
