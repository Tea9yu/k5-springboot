package edu.pnu.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity	// 기본적으로 클래스 이름과 동일한 테이블과 매핑된다. h2에 같은 클래스랑 같은 이름의 테이블과 매핑된다.
//@Builder
//@NoArgsConstructor	// 롬복이 자동으로 매개변수가 없는 기본 생성자를 생성하도록 클래스에 지시한다.
//@AllArgsConstructor	// 모든 필드를 매개변수로 받는 생성자를 생성하도록 클래스에 지시한다.
public class Member {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)	// @id가 선언된 필드에 기본 키 값을 자동으로 할당한다. 데이터베이스에 따라 JAP가 자동으로 결정.
	@Column(name="MEMBER_ID")
	private String id;
	private String password;
	private String name;	
	private String role;
}
