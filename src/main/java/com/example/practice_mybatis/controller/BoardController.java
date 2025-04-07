package com.example.practice_mybatis.controller;

import com.example.practice_mybatis.dto.request.CreateBoardRequestDto;
import com.example.practice_mybatis.dto.response.CreateBoardResponseDto;
import com.example.practice_mybatis.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/save")
    public String save() {
        return "save";
    }

    @PostMapping("/save")
    public String save(@RequestParam String boardTitle,
                       @RequestParam String boardWriter,
                       @RequestParam String boardPass,
                       @RequestParam String boardContents) {
        CreateBoardRequestDto requestDto = new CreateBoardRequestDto(boardTitle, boardWriter, boardPass, boardContents);
        boardService.save(requestDto);
        return "index";
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<CreateBoardResponseDto> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
//        System.out.print("boardDTOList = " + boardDTOList);
        return "list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        // 조회수 처리
        boardService.updateHits(id);
        // 상세 내용 가져오기
        CreateBoardResponseDto responseDto = boardService.findById(id);
        model.addAttribute("board", responseDto);

        return "detail";
    }


}
