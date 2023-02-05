package pagingExam.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pagingExam.demo.domain.Board;
import pagingExam.demo.domain.BoardPage;
import pagingExam.demo.service.BoardServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/board")
@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardServiceImpl boardService;

    @GetMapping("/list/{currentPage}")
    public String boardList(Model model, @PathVariable int currentPage){
        List<Board> boardList = boardService.getBoarddList();
        int totalCount = boardService.getBoardListCount();

        model.addAttribute("list", new BoardPage(totalCount, currentPage,10,5,boardList));
        return "boardList";
    }

    @GetMapping("/create")
    public String getBoardForm(Model model){
        model.addAttribute("board", new Board());
        return "boardForm";
    }

    @PostMapping("/create")
    public String insertForm(@Valid Board board , Model model){
        boardService.insertBoard(board);

        model.addAttribute("message", "가입이 완료 되었습니다.");
        return "redirect:boardList";
    }

    @GetMapping("/edit/{id}")
    public String getBoardContentById(@PathVariable String id, Model model){
        log.info(id);

        return null;
    }
}
