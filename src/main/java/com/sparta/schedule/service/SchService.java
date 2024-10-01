package com.sparta.schedule.service;

import com.sparta.schedule.dto.PageDto;
import com.sparta.schedule.dto.SchRequestDto;
import com.sparta.schedule.dto.SchResponseDto;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.SchRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class SchService {
    private final SchRepository schRepository;

    public SchService(SchRepository schRepository) {
        this.schRepository = schRepository;
    }

    public SchResponseDto createSch(SchRequestDto requsetDto) {

        Schedule schedule = new Schedule(requsetDto);

        Schedule saveSch = schRepository.save(schedule);

        SchResponseDto schResponseDto = new SchResponseDto(saveSch);


        return schResponseDto;
    }


    public List<SchResponseDto> find() {
        return schRepository.findAll();
    }

    public Schedule findByEmail(String email) {
        return schRepository.findByEmail(email);
    }

    public String update(String password, SchRequestDto requsetDto) {

        Schedule schedule = schRepository.findByEmail(requsetDto.getEmail());
        if(Objects.equals(password, schedule.getPassword())) {
            schRepository.update(requsetDto);
            return password;

        }else{
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }



    }

    public String delete(String email, String password) {
        Schedule schedule = schRepository.findByEmail(email);
        if(Objects.equals(password, schedule.getPassword())) {
            schRepository.delete(email);
            return email;

        }else{
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

    }


    public List<SchResponseDto> page(int limit, int offset) {
        return  schRepository.page(limit,offset);
    }
}
