package mni.dev.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;

import mni.dev.beans.Person;
import mni.dev.services.IPersonService;

@WebService(endpointInterface = "mni.dev.services.IPersonService")
public class PersonServiceImpl implements IPersonService{
	
	private final Map<Integer, Person> mapPerson = new HashMap<>();
	
	@Override
	@WebMethod()
	public boolean addPerson(Person p) {
		if(mapPerson.get(p.getId()) != null) return false;
		mapPerson.put(p.getId(), p);
		return true;
	}
	
	@Override
	public boolean deletePerson(Integer id) {
		if(mapPerson.get(id) == null) return false;
		mapPerson.remove(id);
		return true;
	}
	
	@Override
	public Person getPerson(Integer id) {
		return mapPerson.get(id);
	}
	
	@Override
	public Person[] getAllPersons() {
		Set<Integer> ids = mapPerson.keySet();
		Person[] p = new Person[ids.size()];
		int i = 0;
		for(Integer id : ids) {
			p[i] = mapPerson.get(id);
			i++;
		}
		return p;
	}
}
