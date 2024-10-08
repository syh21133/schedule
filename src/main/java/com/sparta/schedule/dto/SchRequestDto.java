package com.sparta.schedule.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class SchRequestDto {
    private int id;
    private String email;
    private String todo;
    private String password;
    private String create_date;
    private String update_date;
    private String name;
}
