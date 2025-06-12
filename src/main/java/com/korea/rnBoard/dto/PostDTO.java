package com.korea.rnBoard.dto;

import com.korea.rnBoard.domain.PostEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // setter, getter
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드를 매개변수로 갖는 생성자
@Builder
public class PostDTO { // DTO -> Entity에 담긴 정보를 DTO에 담아서 클라이언트와 주고 받는 용도
	
	private Long id;
	private String title; // 게시글 제목
	private String author; // 작성자 이름
	private String description; // 게시글 요약/소개
	private String time; // 작성 시각
	private int views; // 조회수(기본값 : 0 으로 서버에서 처리 가능)
	
	
	
	// Entity -> DTO
	public static PostDTO fromEntity(PostEntity entity) {
		return PostDTO.builder()
				.id(entity.getId())
				.title(entity.getTitle())
				.author(entity.getAuthor())
				.description(entity.getDescription())
				.time(entity.getTime())
				.views(entity.getViews())
				.build();
	}
	
	
	// DTO -> Entity
	public static PostEntity toEntity(PostDTO dto) {
		return PostEntity.builder()
				.id(dto.getId())
				.title(dto.getTitle())
				.author(dto.getAuthor())
				.description(dto.getDescription())
				.time(dto.getTime())
				.views(dto.getViews())
				.build();
	}

}
