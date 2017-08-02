package com.authentication.ws;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

//Service Implementation Bean

@WebService(endpointInterface = "com.authentication.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
	
    @Resource
    WebServiceContext wsctx;
    
	@Override
	public String getHelloWorldAsString() {
		MessageContext mctx = wsctx.getMessageContext();
		//get detail from request Header
		
		Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userList = (List) http_headers.get("Username");
		List passList = (List) http_headers.get("Password");
		List ipList = (List) http_headers.get("IP");
		List tokenList = (List) http_headers.get("Token");
		
		
		Properties prop = new Properties();
		InputStream input = null;

		try {
			//InputStream authPath = HelloWorldImpl.class.getResourceAsStream("auth.properties");
			System.getProperty("dir");
			input = new FileInputStream("E:/oldLappy/WORKSPACE/NAJM_WORKSPACE_13_06_2017/ValidateEmail/src/com/authentication/ws/auth.properties");

			
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

		
		String username = "";
		String password = "";
		String ip = "";
		String token = "";

		String Username = prop.getProperty("Username");
		String Password = prop.getProperty("Password");		
		
		String[] ipArray = prop.getProperty("IP").split(",");
		List<String> ipsList = Arrays.asList(ipArray);
		
		//String IP = prop.getProperty("IP");
		String Token = prop.getProperty("Token");

		
		
		if (userList != null) {
			//get username
			username = userList.get(0).toString();
		}
		
		if (passList != null) {
			password = passList.get(0).toString();
		}
		
		
		if (ipList != null) {			
			ip = ipList.get(0).toString();
		}
		
		if (tokenList != null) {
			token = tokenList.get(0).toString();
		}

		
		//Should validate username and password with database/ properties file
		if (username.equals(Username) 
				&& password.equals(Password)
				&& ipsList.contains(ip)
				&& token.equals(Token)) {
			return "Hello World JAX-WS! Valid User";
		} else {
			return "Unknown User";
		}
	}

}
