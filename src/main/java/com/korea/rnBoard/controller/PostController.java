package com.korea.rnBoard.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.rnBoard.dto.PostDTO;
import com.korea.rnBoard.dto.ResponseDTO;
import com.korea.rnBoard.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/posts") // 공통 URL
@RequiredArgsConstructor
public class PostController {
	
	//서비스 주입
	private final PostService p_service;
		
		
	//전체 조회
	@GetMapping
	public ResponseEntity<?> getAllPosts(){
		List<PostDTO> list = p_service.getAllPosts();
		ResponseDTO<PostDTO> response = ResponseDTO.<PostDTO>builder().list(list).build();
		
		return ResponseEntity.ok(list);
				
	}
				
			
	// 상세조회
	@GetMapping("/{id}") // @PathVariable을 통해 URL에서 id를 추출
	public ResponseEntity<?> findById(@PathVariable Long id) {
		List<PostDTO> list = p_service.findById(id);
		ResponseDTO<PostDTO> response = ResponseDTO.<PostDTO>builder().list(list).build();
		
		return ResponseEntity.ok(list);
	}
		
		
	//추가
	@PostMapping
	public ResponseEntity<?> createPost(@RequestBody PostDTO dto){
		List<PostDTO> list = p_service.createPost(dto);
		ResponseDTO<PostDTO> response = ResponseDTO.<PostDTO>builder().list(list).build();
		
		return ResponseEntity.ok(list);
	}
	
}
