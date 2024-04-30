package yqh.pojo.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
@Data
@AllArgsConstructor
public class BookPageQueryVO implements Serializable {
    private String bookName;
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate loanDate;
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate returnDate;
    private Integer status;
    private String borrower;
}
