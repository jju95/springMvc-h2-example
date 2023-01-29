package pagingExam.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pagingExam.demo.domain.Board;
import pagingExam.demo.service.BoardServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/board*")
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardServiceImpl boardService;

    @GetMapping
    public String boardList(Model model){
        List<Board> board = boardService.getBoarddList();
        model.addAttribute("board", board);
        return "boardList";
    }

    @GetMapping("/boardForm")
    public String boardForm(Model model){
        model.addAttribute("board", new Board());
        return "boardForm";
    }

    @PostMapping("/boardForm")
    public ModelAndView insertForm(@Valid Board board , Model model){
        boardService.insertBoard(board);

        model.addAttribute("message", "가입이 완료 되었습니다.");
        return new ModelAndView("redirect:/boardForm");
    }
}
