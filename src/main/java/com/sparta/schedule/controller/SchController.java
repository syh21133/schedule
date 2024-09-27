package com.sparta.schedule.controller;

import com.sparta.schedule.dto.SchRequestDto;
import com.sparta.schedule.dto.SchResponseDto;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.service.SchService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/find/{id}")
    public Schedule findByName(@PathVariable int id) {
        return schService.findById(id);
    }

    @PutMapping("/update/{password}")
    public String updatePassword(@PathVariable String password, @RequestBody SchRequestDto schDto) {
        return schService.update(password,schDto);
    }
    @DeleteMapping("/delete/{id}/{password}")
    public int delete(@PathVariable int id, @PathVariable String password) {
        return schService.delete(id,password);
    }
}
