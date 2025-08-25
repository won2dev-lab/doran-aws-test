package com.example.droranawstest.controller;

import com.example.droranawstest.controller.dto.CreateBoardRequest;
import com.example.droranawstest.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/boards")
@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody
                                       CreateBoardRequest createBoardRequest) {
        boardService.create(
                createBoardRequest.getTitle(),
                createBoardRequest.getContent()
        );
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> getBoardById(@PathVariable("id") Long id) {
        BoardResponse boardResponse = boardService.getBoardById(id);
        return ResponseEntity.ok(boardResponse);
    }
}
