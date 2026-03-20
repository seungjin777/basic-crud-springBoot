package com.example.board.controller;

import com.example.board.domain.Player;
import com.example.board.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    // 선수 전체 조회
    @GetMapping
    public List<Player> getPlayers() {
        return playerService.findAll();
    }

    // 선수 단건 조회
    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable Long id) {
        return playerService.findById(id);
    }
}