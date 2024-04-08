package edu.pnu.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A {
	
	@Autowired
	private B b;

	public A() {
		System.out.println("A");
	}
	
	

}
