package com.example.practice_mybatis.repository;

import com.example.practice_mybatis.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final SqlSessionTemplate sql;
    public void save(BoardDTO boardDTO) {
        // statement : mapper-namespace / id
        sql.insert("Board.save", boardDTO);
    }
}
