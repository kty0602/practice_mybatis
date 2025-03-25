package com.example.practice_mybatis.dto;

import lombok.*;

@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDTO {

    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private String createAt;
}
