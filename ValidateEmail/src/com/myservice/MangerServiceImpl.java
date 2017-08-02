package com.myservice;

import javax.jws.WebService;

//this binds the SEI to the SIB (service implementation Bean)
@WebService(endpointInterface = "com.myservice.ManagerService")
public class MangerServiceImpl implements ManagerService {

/*	@Override
	public Manager getManagerDetails() {
		Manager manger = new Manager("Mike", 45, "SpadeInfoTech");
		return manger;
	}*/
	
	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}

}
