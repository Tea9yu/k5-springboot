package edu.pnu.domain;

import java.util.Date;

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
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long seq;	
	private String title;
	private String writer;
	private String content;
	@Builder.Default
	private Date createDate = new Date();	// 현재 시간과 날짜를 createDate에 넣는다.
	@Builder.Default
	private Long cnt = 0L;	// 0L로 초기화
}
