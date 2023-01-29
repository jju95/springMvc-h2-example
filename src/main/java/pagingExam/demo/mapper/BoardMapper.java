package pagingExam.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import pagingExam.demo.domain.Board;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<Board> selectAll();

    public void insert(Board board);
}
