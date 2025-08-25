package com.example.droranawstest.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateBoardRequest {
    private String title;
    private String content;
}
