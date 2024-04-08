package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
//@WebMvcTest
public class MyTestOrderTest {
	
	
	@Test
//	@Order(3)
	public void test01() {
		System.out.println("test01");
	}
	
	@Test
//	@Order(2)
	public void test02() {
		System.out.println("test02");
	}
	
	@Test
//	@Order(1)
	public void test03() {
		System.out.println("test03");
	}
	
}
