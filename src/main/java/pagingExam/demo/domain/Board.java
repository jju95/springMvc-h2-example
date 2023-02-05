package pagingExam.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data
public class Board {

    private Long boardId;

    @NotNull(message = "글 제목을 입력하세요")
    public String title;

    @NotNull(message = "작성자를 입력하세요")
    public String writer;

    @Nullable
    public String content;

    @Nullable
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-mm-dd HH:mm:ss") // response
    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss") // request
    public LocalDateTime createDate;


    public Long viewCnt = 0L;

    @Nullable
    public MultipartFile image;

    public String imageSrc;
}
