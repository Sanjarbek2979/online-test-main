package com.example.onlinetest.entity;

import com.example.onlinetest.entity.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue
    private UUID id=UUID.randomUUID();

    private String text;


    @Enumerated(EnumType.STRING)
    private QuestionType type;

    private String correctAnswer;

    @ManyToOne
    private Subject subject;

    private boolean active=true;

}
