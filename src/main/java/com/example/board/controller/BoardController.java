package com.example.board.controller;


import com.example.board.domain.Board;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    // 롬복으로 자동 DI
    private final BoardService boardService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/boards/write")
    public String writeForm(){
        return "boardWrite";
    }

    @PostMapping("/boards/write")
    public String write(Board board){

        boardService.save(board);

        return "redirect:/boards";
    }

    @GetMapping("/boards")
    public String list(Model model){

        model.addAttribute("boards", boardService.findAll());

        return "boardList";
    }

    @GetMapping("/boards/{id}")
    public String detail(@PathVariable Long id, Model model){
        model.addAttribute("board", boardService.findById(id).orElse(null));

        return "boardDetail";
    }

    @GetMapping("/boards/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){

        Board board = boardService.findById(id).orElse(null);

        model.addAttribute("board", board);

        return "boardEdit";
    }

    @PostMapping("/boards/update/{id}")
    public String update(@PathVariable Long id, Board board){

        Board existingBoard = boardService.findById(id).orElse(null);

        if(existingBoard != null){
            existingBoard.setTitle(board.getTitle());
            existingBoard.setWriter(board.getWriter());
            existingBoard.setContent(board.getContent());

            boardService.save(existingBoard);
        }

        return "redirect:/boards/" + id;
    }

    @PostMapping("/boards/delete/{id}")
    public String delete(@PathVariable Long id){
        boardService.delete(id);

        return "redirect:/boards";
    }
}