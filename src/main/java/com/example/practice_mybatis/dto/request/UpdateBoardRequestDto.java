package com.example.practice_mybatis.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateBoardRequestDto {

    private String boardTitle;
    private String boardContents;
}
