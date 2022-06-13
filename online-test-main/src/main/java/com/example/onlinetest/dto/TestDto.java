package com.example.onlinetest.dto;


import lombok.Data;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
public class TestDto {

    private Integer amountOfQuestions;
    private Integer time;

    private Integer subjectId;
}
