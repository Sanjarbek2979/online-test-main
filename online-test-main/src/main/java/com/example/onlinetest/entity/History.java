package com.example.onlinetest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class History {

    @Id
    @GeneratedValue
    private UUID id=UUID.randomUUID();

    private LocalDateTime localDateTime=LocalDateTime.now();

    private Double point;

    @ManyToOne
    private User user;

}
