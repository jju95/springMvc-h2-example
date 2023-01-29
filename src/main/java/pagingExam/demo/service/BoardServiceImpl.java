package pagingExam.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pagingExam.demo.domain.Board;
import pagingExam.demo.mapper.BoardMapper;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Resource
    private BoardMapper boardMapper;

    public List<Board> getBoarddList(){

        return null;
    }

    @Override
    public void insertBoard(Board board) {
        LocalDateTime currentTime = LocalDateTime.now();
        board.setCreateDt(currentTime);

        log.info("board == {}", board);

        boardMapper.insert(board);
    }
}
