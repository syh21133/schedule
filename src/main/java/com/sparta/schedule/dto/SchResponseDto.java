package com.sparta.schedule.dto;

import com.sparta.schedule.entity.Schedule;
import lombok.Getter;

import java.util.Date;

@Getter
public class SchResponseDto {
    private int id;
    private String name;
    private String todo;
    private String password;
    private String create_date;
    private String update_date;


    public SchResponseDto(Schedule schedule){
        this.id=schedule.getId();
        this.todo=schedule.getTodo();
        this.name=schedule.getName();
        this.password=schedule.getPassword();
        this.create_date=schedule.getCreate_date();
        this.update_date=schedule.getUpdate_date();

    }

    public SchResponseDto(int id,String name, String todo, String password, String create_date, String update_date) {
        this.name = name;
        this.todo = todo;
        if(password == null){
            this.password="";
        }else{this.password = password;}

        this.create_date=create_date;
        this.update_date=update_date;

    }


}
