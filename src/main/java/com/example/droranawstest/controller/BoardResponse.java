package com.example.droranawstest.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponse {
    private Long id;
    private String title;
    private String content;
}
