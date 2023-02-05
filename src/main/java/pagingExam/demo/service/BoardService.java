package pagingExam.demo.service;

import pagingExam.demo.domain.Board;

import java.util.List;

public interface BoardService {

    public int getBoardListCount();
    public List<Board> getBoarddList();

    public void insertBoard(Board board);

    public Board getById(String id);

    public void updateById(Board board);

    public void deleteById(String id);
}
