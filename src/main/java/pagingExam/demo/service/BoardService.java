package pagingExam.demo.service;

import pagingExam.demo.domain.Board;

import java.util.List;

public interface BoardService {
    public List<Board> getBoarddList();

    public void insertBoard(Board board);
}
