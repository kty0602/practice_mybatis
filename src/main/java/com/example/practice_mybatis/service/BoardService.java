package com.example.practice_mybatis.service;

import com.example.practice_mybatis.domain.BoardEntity;
import com.example.practice_mybatis.dto.request.CreateBoardRequestDto;
import com.example.practice_mybatis.dto.response.CreateBoardResponseDto;
import com.example.practice_mybatis.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(CreateBoardRequestDto requestDto) {
        BoardEntity boardEntity = requestDto.toEntity();
        boardRepository.save(boardEntity);
    }

    public List<CreateBoardResponseDto> findAll() {
        return boardRepository.findAll();
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public CreateBoardResponseDto findById(Long id) {
        return boardRepository.findById(id);
    }
}
