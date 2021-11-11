package mni.dev.services;

import javax.xml.ws.Endpoint;

import mni.dev.services.impl.PersonServiceImpl;

public class PersonSoapPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8888/ws/person", new PersonServiceImpl());
	}
}
