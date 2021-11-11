package mni.dev.services.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import mni.dev.beans.Person;
import mni.dev.services.IPersonService;

public class PersonSoapPublisherClient {
	public static void main(String[] args) {
		URL wsdlURL = null;
		try {
			wsdlURL = new URL("http://localhost:8888/ws/person?wsdl");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		QName qname = new QName("http://impl.services.dev.mni/", "PersonServiceImplService");
		
		Service service = Service.create(wsdlURL, qname);
		
		IPersonService ps = service.getPort(IPersonService.class);
		
		Person p1 = new Person(); p1.setName("Gopur"); p1.setId(1); p1.setAge(30);
		Person p2 = new Person(); p2.setName("Akbar"); p2.setId(2); p1.setAge(25);
		
		System.out.println("Add Person Status= " + ps.addPerson(p1));
		System.out.println("Add Person Status= " + ps.addPerson(p2));
		
		System.out.println(ps.getPerson(1));
		
		System.out.println(Arrays.asList(ps.getAllPersons()));
		
		System.out.println("Delete Person Status= "+ ps.deletePerson(2));
		
		System.out.println(Arrays.asList(ps.getAllPersons()));
	
	}
}
