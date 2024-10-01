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

    @PostMapping("/Sch")
    public SchResponseDto createSch(@RequestBody SchRequestDto schDto) {

        return schService.createSch(schDto);

    }
    @GetMapping("/find")
    public List<SchResponseDto> findSch() {
        return schService.find();
    }

    @GetMapping("/find/{email}")
    public Schedule findByEmail(@PathVariable String email) {
        return schService.findByEmail(email);
    }

    @PutMapping("/update/{password}")
    public String updatePassword(@PathVariable String password, @RequestBody SchRequestDto schDto) {
        return schService.update(password,schDto);
    }
    @DeleteMapping("/delete/{email}/{password}")
    public String delete(@PathVariable String email, @PathVariable String password) {
        return schService.delete(email,password);
    }

    @GetMapping("/page/{limit}/{offset}")
    public List<SchResponseDto> page(@PathVariable int limit,@PathVariable int offset) {
        return schService.page(limit,offset);
    }





}
