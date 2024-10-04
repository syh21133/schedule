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
    // 일정 생성
    public SchResponseDto createSch(SchRequestDto requsetDto) {

        Schedule schedule = new Schedule(requsetDto);

        Schedule saveSch = schRepository.save(schedule);

        SchResponseDto schResponseDto = new SchResponseDto(saveSch);


        return schResponseDto;
    }

    // 일정 조회
    public List<SchResponseDto> find() {
        return schRepository.findAll();
    }
    // 이메일로 검색
    public Schedule findByEmail(String email) {
        return schRepository.findByEmail(email);
    }
    // 일정 수정
    public String update(String password, SchRequestDto requsetDto) {


        Schedule schedule = schRepository.findByEmail(requsetDto.getEmail());
        // 비밀번호 확인
        if(Objects.equals(password, schedule.getPassword())) {
            schRepository.update(requsetDto);
            return password;

        }else{
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }



    }
    // 일정삭제
    public String delete(String email, String password) {
        Schedule schedule = schRepository.findByEmail(email);
        // 비밀번호 확인
        if(Objects.equals(password, schedule.getPassword())) {
            schRepository.delete(email);
            return email;

        }else{
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

    }


    public List<SchResponseDto> page(int page, int limit) {
        return  schRepository.page(page,limit);
    }
}
