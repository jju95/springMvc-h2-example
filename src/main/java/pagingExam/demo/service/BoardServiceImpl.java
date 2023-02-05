package pagingExam.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import pagingExam.demo.common.exception.NoDataFoundException;
import pagingExam.demo.domain.Board;
import pagingExam.demo.mapper.BoardMapper;

import javax.annotation.Resource;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public int getBoardListCount() {
        return boardMapper.getAllCount();
    }


    public List<Board> getBoarddList(){
        return boardMapper.selectAll();
    }

    @Override
    public void insertBoard(Board board) {
        this.fileUpload(board);
        LocalDateTime currentTime = LocalDateTime.now();
        board.setCreateDate(currentTime);

        boardMapper.insert(board);
    }
    @Override
    public Board getById(String id) {
        return null;
    }

    @Override
    public void updateById(Board board) {

    }

    @Override
    public void deleteById(String id) {

    }

    void fileUpload(Board board){
        if(board.getImage().isEmpty()) {
            return;
        }

        String filePath = "classpath:/image/";
        MultipartFile file = board.getImage();
        String uploadFileName = file.getOriginalFilename();
        // 저장할 파일, 생성자로 경로와 이름을 지정해줌.
        File saveFile = new File(filePath, uploadFileName);

        try {
            // void transferTo(File dest) throws IOException 업로드한 파일 데이터를 지정한 파일에 저장
            file.transferTo(saveFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        board.setImageSrc(filePath+uploadFileName);

    }

}
