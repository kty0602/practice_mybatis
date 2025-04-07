package com.example.practice_mybatis.repository;

import com.example.practice_mybatis.domain.BoardEntity;
import com.example.practice_mybatis.dto.response.CreateBoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final SqlSessionTemplate sql;
    public void save(BoardEntity boardEntity) {
        // statement : mapper-namespace / id
        sql.insert("Board.save", boardEntity);
    }

    public List<CreateBoardResponseDto> findAll() {
        return sql.selectList("Board.findAll");
    }

    public void updateHits(Long id) {
        sql.update("Board.updateHits", id);
    }

    public CreateBoardResponseDto findById(Long id) {
        return sql.selectOne("Board.findById", id);
    }
}
