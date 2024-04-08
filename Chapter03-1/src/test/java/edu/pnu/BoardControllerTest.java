//package edu.pnu;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//@SpringBootTest
//@AutoConfigureMockMvc
////@WebMvcTest
//public class BoardControllerTest {
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Test
////	@Order(2)
//	// http://localhost:8080/hello?name=둘리
//	public void testHello() throws Exception {
//		mockMvc.perform(get("/hello").param("name", "둘리"))
//		.andExpect(status().isOk())
//		.andExpect(content().string("Hello : 둘리"))
//		.andDo(print());
//	}
//	
//	@Test
////	@Order(1)
//	// http://localhost:8080/hello?name=홍길동
//	public void testHello2() throws Exception {
//		mockMvc.perform(get("/hello").param("name", "홍길동"))
//		.andExpect(status().isOk())
//		.andExpect(content().string("Hello : 홍길동"))
//		.andDo(print());
//	}
//}
