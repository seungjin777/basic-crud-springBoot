package com.example.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "player_basic")
@Getter
@NoArgsConstructor
public class Player {

    @Id
    @Column(name = "PID")
    private Long id;

    @Column(name = "player_name")
    private String name;

    @Column(name = "player_number")
    private Integer number;

    @Column(name = "player_birthday")
    private LocalDate birthday;

    @Column(name = "height_weight")
    private String heightWeight;

    @Column(name = "player_m_position")
    private String position;

    @Column(name = "player_history")
    private String history;

    @Column(name = "player_entryfee")
    private Integer entryFee;

    @Column(name = "player_salary")
    private Integer salary;

    @Column(name = "player_draft")
    private String draft;

    @Column(name = "player_enter")
    private String enterYear;
}