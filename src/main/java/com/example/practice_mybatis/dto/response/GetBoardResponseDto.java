package com.example.practice_mybatis.dto.response;

import lombok.Getter;

@Getter
public class GetBoardResponseDto {

    private Long id;
    private String boardTitle;
    private String boardWriter;
    private String boardPass;
    private String boardContents;
    private int boardHits;
    private String createdAt;
    private int fileAttached;
}
