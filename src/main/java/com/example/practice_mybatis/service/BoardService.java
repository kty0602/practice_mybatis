package com.example.practice_mybatis.service;


import com.example.practice_mybatis.domain.Board;
import com.example.practice_mybatis.domain.BoardFile;
import com.example.practice_mybatis.dto.request.CreateBoardRequestDto;
import com.example.practice_mybatis.dto.request.UpdateBoardRequestDto;
import com.example.practice_mybatis.dto.response.GetBoardFileResponseDto;
import com.example.practice_mybatis.dto.response.GetBoardResponseDto;
import com.example.practice_mybatis.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(CreateBoardRequestDto requestDto) throws IOException {
        List<MultipartFile> files = requestDto.getBoardFile();
        boolean hasFile = files != null && !files.isEmpty();

        Board boardEntity = requestDto.toEntity(hasFile);
        Board board = boardRepository.save(boardEntity);

        if (hasFile) {
            for (MultipartFile file : files) {
                if (file.isEmpty()) continue;

                String originalFileName = file.getOriginalFilename();
                String storedFileName = System.currentTimeMillis() + "-" + originalFileName;

                String savePath = "C:/Users/User/testMyBatis/" + storedFileName;
                file.transferTo(new File(savePath));

                // BoardFile 객체 생성 및 저장
                BoardFile boardFile = new BoardFile(board.getId(), originalFileName, storedFileName);
                boardRepository.saveFile(boardFile);
            }
        }
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

    public List<GetBoardFileResponseDto> findFile(Long id) {
        return boardRepository.findFile(id);
    }

}
