package com.sparta.schedule.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageDto {
    private int limit;		// 한 페이지에 출력할 게시글 갯수
    private int offset;     // 시작 행
}
