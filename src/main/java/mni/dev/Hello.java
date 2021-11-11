package mni.dev;

import javax.jws.WebMethod;
import javax.xml.ws.WebServiceClient;

@WebServiceClient
public class Hello {
	
	@WebMethod
	public String bonjour(String name) {
		return "Hello "+ name;
	}
	
}
