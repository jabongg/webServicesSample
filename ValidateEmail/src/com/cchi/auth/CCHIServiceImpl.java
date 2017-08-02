package com.cchi.auth;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.cchi.auth.TripleDESUtil;
//Service Implementation Bean

@WebService(endpointInterface = "com.cchi.auth.CCHIService")
public class CCHIServiceImpl implements CCHIService {
	
    @Resource
    WebServiceContext wsctx;
    
	@Override
	public String getHelloWorldAsString() {
		MessageContext mctx = wsctx.getMessageContext();
		//get detail from request Header
		
		Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		List companyList = (List) http_headers.get("Company");
		List serviceList = (List) http_headers.get("Service");
		List accessTokenList = (List) http_headers.get("AccessToken");
		
		try {
			String tripDes = TripleDESUtil.generateKey();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		

		Properties prop = new Properties();
		InputStream input = null;

		try {
			//InputStream authPath = HelloWorldImpl.class.getResourceAsStream("auth.properties");
			//System.getProperty("dir");
			input = new FileInputStream("E:/oldLappy/WORKSPACE/NAJM_WORKSPACE_13_06_2017/ValidateEmail/src/com/cchi/auth/cchi.auth.properties");

			
			// load a properties file
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		
		String companyName = "";
		String serviceName = "";
		String accessToken = "";

		String _Company = prop.getProperty("Company");
		String _Service = prop.getProperty("Service");		
		String _AccessToken = prop.getProperty("AccessToken");

		
		
		if (companyList != null) {
			//get company name
			companyName = companyList.get(0).toString();
		}
		
		if (serviceList != null) {
			serviceName = serviceList.get(0).toString();
		}
		
		
		if (accessTokenList != null) {			
			accessToken = accessTokenList.get(0).toString();
		}
		
/*		String encodedAccessToken = null;
		
		try {
			 encodedAccessToken = TripleDESUtil.generateTokenFromHTTPHeaders(companyName, serviceName, accessToken);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (encodedAccessToken != null && encodedAccessToken.equals(_AccessToken)) {
			return "Hello World JAX-WS! Valid User";
		} else {
			return "Unknown User";
		}
		*/
		
  //Should validate company, service name and access token from database/ properties file
		if (companyName.equals(_Company) 
				&& serviceName.equals(_Service)
				&& accessToken.equals(_AccessToken)) {
			// getBeneficiaryDetails(); 
			// need to search for maintaining session during the soap request calls
			return "Hello World JAX-WS! Valid User";
		} else {
			return "Unknown User";
		}
 
	}

	@Override
	public String getToken(String companyName, String serviceName, String accessToken) {
		String encodedAccessToken = null;
		try {			
			encodedAccessToken = TripleDESUtil.generateTokenFromHTTPHeaders(companyName, serviceName, accessToken);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedAccessToken;
	}

	List<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();
	
	@Override
	public List<Beneficiary> getBeneficiaryDetails(String visaNumber,
			String passportNumber) {
		List<Beneficiary> benefDetails = new ArrayList<Beneficiary>();
		
		
		Beneficiary benefName = null;
	        boolean isValidBeneficiary = false;
	        for (int i = 0; i < beneficiaryList.size(); i++) {
	        	benefName = beneficiaryList.get(i);
	           
	        	if (benefName.getPassportNumber().equals(passportNumber)) {
	                System.out.println("param found: " + benefName.getPassportNumber());
	            }
	        	
	        	if (benefName.getVisaNumber().equals(visaNumber)) {
	                System.out.println("param found: " + benefName.getVisaNumber());
	            }
	        	
	        	if (benefName.getVisaNumber().equals(visaNumber) 
	        			&& benefName.getPassportNumber().equals(passportNumber)) {
	        		isValidBeneficiary = true;
	        		benefDetails.add(benefName);
	            }

	        }
	        
	        if (isValidBeneficiary) {
	        	return benefDetails;
	        } else {
	        	return null;
	        }
	}
	
	@Override
	public boolean addBeneficiary(@WebParam(partName = "name") String name,
			@WebParam(partName = "email") String email,
			@WebParam(partName = "pass") String passportNumber,
			@WebParam(partName = "visa") String visaNumber) {

		beneficiaryList.add(new Beneficiary(name, email, passportNumber,
				visaNumber));
		return true;
	}

}
