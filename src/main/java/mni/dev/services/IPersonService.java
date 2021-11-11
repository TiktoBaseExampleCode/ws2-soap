package mni.dev.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import mni.dev.beans.Person;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IPersonService {
	
	@WebMethod
	public boolean addPerson(Person p);
	
	@WebMethod
	public boolean deletePerson(Integer p);
	
	@WebMethod
	public Person getPerson(Integer id);
	
	@WebMethod
	public Person[] getAllPersons();

}
