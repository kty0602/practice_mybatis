package com.example.practice_mybatis.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardEntity {

    private final Long id;
    private final String boardTitle;
    private final String boardWriter;
    private final String boardPass;
    private final String boardContents;
    private final int boardHits;
    private final LocalDateTime createdAt;
    private final int fileAttached;

    // DB 저장 시 사용하는 생성자
    public BoardEntity(String boardTitle, String boardWriter, String boardPass, String boardContents) {
        this.id = null; // insert 후 자동 생성
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardPass = boardPass;
        this.boardContents = boardContents;
        this.boardHits = 0;
        this.createdAt = null; // DB에서 자동 입력
        this.fileAttached = 0;
    }
}
