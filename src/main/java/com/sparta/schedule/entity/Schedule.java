package com.sparta.schedule.entity;

import com.sparta.schedule.dto.SchRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Schedule {
    private int id;
    private String name;
    private String todo;
    private String password;
    private String create_date;
    private String update_date;

    public Schedule(SchRequestDto schDto) {
        this.id = schDto.getId();
    this.todo=schDto.getTodo();
    this.name=schDto.getName();
    this.password=schDto.getPassword();
    this.create_date=schDto.getCreate_date();
    this.update_date=schDto.getUpdate_date();

    }
    public void update(SchRequestDto schDto) {
        this.id=schDto.getId();
        this.todo=schDto.getTodo();
        this.name=schDto.getName();
        this.password=schDto.getPassword();
        this.create_date=schDto.getCreate_date();
        this.update_date=schDto.getUpdate_date();

    }

}
