package com.example.droranawstest.service;

import com.example.droranawstest.controller.BoardResponse;
import com.example.droranawstest.domain.Board;
import com.example.droranawstest.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public void create(String title, String content) {
        Board board = new Board(title, content);
        boardRepository.save(board);
    }

    @Cacheable(cacheNames = "board", key = "#id")
    public BoardResponse getBoardById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow();

        return new BoardResponse(
                board.getId(),
                board.getTitle(),
                board.getContent()
        );
    }
}
