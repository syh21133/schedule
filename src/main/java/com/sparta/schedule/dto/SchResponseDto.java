package com.sparta.schedule.dto;

import com.sparta.schedule.entity.Schedule;
import lombok.Getter;

import java.util.Date;

@Getter
public class SchResponseDto {
    private int id;
    private String email;
    private String todo;
    private String password;
    private String create_date;
    private String update_date;
    private String name;


    public SchResponseDto(Schedule schedule){
        this.id=schedule.getId();
        this.todo=schedule.getTodo();
        this.email=schedule.getEmail();
        this.password=schedule.getPassword();
        this.create_date=schedule.getCreate_date();
        this.update_date=schedule.getUpdate_date();

    }

    public SchResponseDto(int id,String email, String todo, String password, String create_date, String update_date,String name) {
        this.id=id;
        this.email = email;
        this.todo = todo;
        if(password == null){
            this.password="";
        }else{this.password = password;}

        this.create_date=create_date;
        this.update_date=update_date;
        this.name=name;

    }


    public SchResponseDto(String name) {
        this.name=name;
    }
}
