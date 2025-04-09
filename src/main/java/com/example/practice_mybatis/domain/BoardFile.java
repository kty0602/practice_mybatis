package com.example.practice_mybatis.domain;

import lombok.Getter;

@Getter
public class BoardFile {

    private Long id;
    private Long boardId;
    private String originalFileName;
    private String storedFileName;

    public BoardFile(Long boardId, String originalFileName, String storedFileName) {
        this.id = null; // DB에서 자동 생성
        this.boardId = boardId;
        this.originalFileName = originalFileName;
        this.storedFileName = storedFileName;
    }
}
