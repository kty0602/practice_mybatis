package com.example.practice_mybatis.service;


import com.example.practice_mybatis.domain.Board;
import com.example.practice_mybatis.dto.request.CreateBoardRequestDto;
import com.example.practice_mybatis.dto.request.UpdateBoardRequestDto;
import com.example.practice_mybatis.dto.response.GetBoardResponseDto;
import com.example.practice_mybatis.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(CreateBoardRequestDto requestDto) {
        Board boardEntity = requestDto.toEntity();
        boardRepository.save(boardEntity);
    }

    public List<GetBoardResponseDto> findAll() {
        return boardRepository.findAll();
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public GetBoardResponseDto findById(Long id) {
        return boardRepository.findById(id);
    }

    public void update(UpdateBoardRequestDto requestDto, Long id) {
        boardRepository.update(requestDto, id);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }

}
