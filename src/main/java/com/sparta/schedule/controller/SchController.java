package com.sparta.schedule.controller;

import com.sparta.schedule.dto.PageDto;
import com.sparta.schedule.dto.SchRequestDto;
import com.sparta.schedule.dto.SchResponseDto;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.service.SchService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SchController {

    private final SchService schService;

    public SchController(SchService schService) {
        this.schService = schService;
    }

    // 일정 생성
    @PostMapping("/Sch")
    public SchResponseDto createSch(@RequestBody SchRequestDto schDto) {

        return schService.createSch(schDto);
    }
    // 일정 조회
    @GetMapping("/find")
    public List<SchResponseDto> findSch() {
        return schService.find();
    }
    // 이메일로 검색 조회
    @GetMapping("/find/{email}")
    public Schedule findByEmail(@PathVariable String email) {
        return schService.findByEmail(email);
    }
    // 일정 수정
    @PutMapping("/update/{password}")
    public String updatePassword(@PathVariable String password, @RequestBody SchRequestDto schDto) {
        return schService.update(password,schDto);
    }
    // 일정 삭제
    @DeleteMapping("/delete/{email}/{password}")
    public String delete(@PathVariable String email, @PathVariable String password) {
        return schService.delete(email,password);
    }
    // 페이징 처리
    @GetMapping("/page/{page}/{limit}")
    public List<SchResponseDto> page(@PathVariable int page,@PathVariable int limit) {
        return schService.page(page,limit);
    }





}
