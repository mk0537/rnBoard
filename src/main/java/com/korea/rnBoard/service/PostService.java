package com.korea.rnBoard.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.korea.rnBoard.domain.PostEntity;
import com.korea.rnBoard.dto.PostDTO;
import com.korea.rnBoard.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository repository;
		
	
		
	// 전체 조회
	public List<PostDTO> getAllPosts(){
		return repository.findAll()
				.stream().map(PostDTO::fromEntity) // 하나씩 꺼내서 PostDTO를 PostEntity 타입으로 변경해서
				.toList(); // 리스트에 담음
	}
	
		
	//게시글 상세 조회
	public List<PostDTO> findById(Long id){
		Optional<PostEntity> entity = repository.findById(id);
		// Optional : null을 안전하게 다루기 위한 Wrapper 클래스
		// null 값으로 발생하는 에러를 방지하고
		// 값이 있을 수도, 없을 수도 있는 객체를 명확하게 표현하는 방법
		
		PostDTO dto = null;
		
		if(entity.isPresent()) { // 값이 있으면
			dto = PostDTO.fromEntity(entity.get());
		}
		
		return Arrays.asList(dto);
		
	}
		
		
	//게시글 추가
	public List<PostDTO> createPost(PostDTO dto){
		PostDTO result = PostDTO.fromEntity(
				repository.save(
						PostDTO.toEntity(dto)));
		
		return Arrays.asList(result);
	
	}
}


	 
	
