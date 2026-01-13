package com.example.SpringTask10.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@AllArgsConstructor
@Data
public class ResponseDto {

    Timestamp  timestamp;
    HttpStatus status;
    Object message;
    String path;

}
