package com.example.onlinetest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sanjarbek Allayev, чт 9:12. 24.02.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {
private String message;
private boolean success;
private Object object;

    public Response(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
