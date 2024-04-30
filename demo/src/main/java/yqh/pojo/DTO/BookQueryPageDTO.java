package yqh.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookQueryPageDTO implements Serializable {
    private String bookName;
    private String borrower;
    private Integer pageSize;
    // 页码
    private Integer pagination;
}
