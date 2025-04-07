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

    // 조회 시 사용하는 전체 필드용 생성자
    public BoardEntity(Long id, String boardTitle, String boardWriter, String boardPass,
                       String boardContents, int boardHits, LocalDateTime createdAt, int fileAttached) {
        this.id = id;
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardPass = boardPass;
        this.boardContents = boardContents;
        this.boardHits = boardHits;
        this.createdAt = createdAt;
        this.fileAttached = fileAttached;
    }

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
