package yqh.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import yqh.pojo.VO.BookPageQueryVO;

import java.io.Serializable;
import java.util.List;
@Data
@AllArgsConstructor
public class PageResult implements Serializable {
    private long total; //总记录数

    private List<?> records; //当前页数据集合

}
