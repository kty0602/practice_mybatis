package com.example.practice_mybatis.dto.response;

import lombok.Getter;

@Getter
public class GetBoardFileResponseDto {

    private Long id;
    private Long boardId;
    private String originalFileName;
    private String storedFileName;
}
