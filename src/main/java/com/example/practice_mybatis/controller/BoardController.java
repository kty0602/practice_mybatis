package com.example.practice_mybatis.controller;

import com.example.practice_mybatis.dto.request.CreateBoardRequestDto;
import com.example.practice_mybatis.dto.request.UpdateBoardRequestDto;
import com.example.practice_mybatis.dto.response.GetBoardFileResponseDto;
import com.example.practice_mybatis.dto.response.GetBoardResponseDto;
import com.example.practice_mybatis.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
                       @RequestParam String boardContents,
                       @RequestParam(required = false) MultipartFile boardFile) throws IOException {
        CreateBoardRequestDto requestDto =
                new CreateBoardRequestDto(boardTitle, boardWriter, boardPass, boardContents, boardFile);
        boardService.save(requestDto);
        return "index";
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<GetBoardResponseDto> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
//        System.out.print("boardDTOList = " + boardDTOList);
        return "list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        // 조회수 처리
        boardService.updateHits(id);
        // 상세 내용 가져오기
        GetBoardResponseDto responseDto = boardService.findById(id);
        model.addAttribute("board", responseDto);
        if (responseDto.getFileAttached() == 1) {
            GetBoardFileResponseDto getBoardFileResponseDto = boardService.findFile(id);
            model.addAttribute("boardFile", getBoardFileResponseDto);
        }

        return "detail";
    }

    // 수정하는 화면으로 이동
    @GetMapping("update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        GetBoardResponseDto responseDto = boardService.findById(id);
        model.addAttribute("board", responseDto);
        return "update";
    }

    // 수정 실행
    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Long id, @RequestParam String boardTitle,
                         @RequestParam String boardContents, Model model) {
        UpdateBoardRequestDto requestDto = new UpdateBoardRequestDto(boardTitle, boardContents);
        boardService.update(requestDto, id);
        GetBoardResponseDto responseDto = boardService.findById(id);
        model.addAttribute("board", responseDto);
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        boardService.delete(id);
        return "redirect:/list";
    }
}
