package edu.pnu;


import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestOrderTest {
	
	// test03 => test02 => test01 순으로 실행
	
	@Test
	@Order(3)
	public void test01() {
		System.out.println("test01");
	}
	
	@Test
	@Order(2)
	public void test02() {
		System.out.println("test02");
	}
	
	@Test
	@Order(1)
	public void test03() {
		System.out.println("test03");
	}
}
