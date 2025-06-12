package com.korea.rnBoard.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // AUTO:내가 연결한 DB 값에 따라 연결됨. IDENTITY:자동으로 1번부터 들어감
	private Long id;
	
	private String title; // 게시글 제목
	private String author; // 작성자 이름
	private String description; // 게시글 요약/소개
	private String time; // 작성 시각
	private int views; // 조회수(기본값 : 0 으로 서버에서 처리 가능)
}
