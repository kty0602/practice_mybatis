package com.example.practice_mybatis.repository;

import com.example.practice_mybatis.domain.Board;
import com.example.practice_mybatis.dto.request.UpdateBoardRequestDto;
import com.example.practice_mybatis.dto.response.GetBoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final SqlSessionTemplate sql;
    public void save(Board boardEntity) {
        // statement : mapper-namespace / id
        sql.insert("Board.save", boardEntity);
    }

    public List<GetBoardResponseDto> findAll() {
        return sql.selectList("Board.findAll");
    }

    public void updateHits(Long id) {
        sql.update("Board.updateHits", id);
    }

    public GetBoardResponseDto findById(Long id) {
        return sql.selectOne("Board.findById", id);
    }

    public void update(UpdateBoardRequestDto requestDto, Long id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("boardTitle", requestDto.getBoardTitle());
        paramMap.put("boardContents", requestDto.getBoardContents());
        paramMap.put("id", id);
        sql.update("Board.update", paramMap);
    }
}
