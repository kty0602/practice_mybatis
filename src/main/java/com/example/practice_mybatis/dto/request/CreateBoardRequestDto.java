package com.example.practice_mybatis.dto.request;

import com.example.practice_mybatis.domain.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateBoardRequestDto {

    private String boardTitle;
    private String boardWriter;
    private String boardPass;
    private String boardContents;

    public BoardEntity toEntity() {
        return new BoardEntity(boardTitle, boardWriter, boardPass, boardContents);
    }
}
