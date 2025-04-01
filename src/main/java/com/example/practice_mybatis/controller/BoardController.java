package com.example.practice_mybatis.controller;

import com.example.practice_mybatis.dto.BoardDTO;
import com.example.practice_mybatis.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/save")
    public String save() {
        return "save";
    }

    // BoardDTO에 @Setter가 있을 때 가능
//    @PostMapping("/save")
//    public String save(BoardDTO boardDTO) {
//        System.out.println("boardDto = " + boardDTO);
//        return "index";
//    }

    @PostMapping("/save")
    public String save(@RequestParam String boardTitle,
                       @RequestParam String boardWriter,
                       @RequestParam String boardPass,
                       @RequestParam String boardContents) {
        System.out.println("boardTitle = " + boardTitle);
        System.out.println("boardWriter = " + boardWriter);
        System.out.println("boardPass = " + boardPass);
        System.out.println("boardContents = " + boardContents);
        boardService.save(boardTitle, boardWriter, boardPass, boardContents);
        return "index";
    }


}
