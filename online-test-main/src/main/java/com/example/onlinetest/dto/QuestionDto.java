package com.example.onlinetest.dto;

import com.example.onlinetest.entity.enums.QuestionType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Sanjarbek Allayev, чт 11:34. 31.03.2022
 */
@Data
public class QuestionDto {

    private Integer subjectId;
    private String text;
    private String type;
    private String correctAnswer;
}
