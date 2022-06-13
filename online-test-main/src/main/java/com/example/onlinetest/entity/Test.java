package com.example.onlinetest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Test {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToMany
    private List<Question> questions;


    @ManyToOne
    private Subject subject;

    private Integer time;

    private Timestamp timestamp;
}
