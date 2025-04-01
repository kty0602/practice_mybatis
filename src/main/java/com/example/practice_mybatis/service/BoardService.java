package com.example.practice_mybatis.service;

import com.example.practice_mybatis.dto.BoardDTO;
import com.example.practice_mybatis.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(String boardTitle, String boardWriter, String boardPass, String boardContents) {
        BoardDTO boardDto =
                new BoardDTO(null, boardWriter, boardPass, boardTitle, boardContents, 0, null);

        boardRepository.save(boardDto);
    }
}
