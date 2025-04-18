package com.example.practice_mybatis.dto.request;

import com.example.practice_mybatis.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateBoardRequestDto {

    private String boardTitle;
    private String boardWriter;
    private String boardPass;
    private String boardContents;
    private List<MultipartFile> boardFile;

    public Board toEntity(boolean hasFile) {
        return new Board(boardTitle, boardWriter, boardPass, boardContents, hasFile);
    }
}
