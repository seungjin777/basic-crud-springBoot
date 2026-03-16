package com.example.board.service;

import com.example.board.domain.Board;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 저장
    public Board save(Board board){
        return boardRepository.save(board);
    }

    // 전체 게시글 조회
    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    // 게시글 하나 조회
    public Optional<Board> findById(Long id){
        return boardRepository.findById(id);
    }

    // 게시글 삭제
    public void delete(Long id){
        boardRepository.deleteById(id);
    }
}