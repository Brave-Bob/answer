package yqh.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import yqh.pojo.DTO.BookLoanDTO;
import yqh.pojo.DTO.BookQueryPageDTO;
import yqh.pojo.VO.BookPageQueryVO;
import yqh.pojo.entity.Book;
import yqh.pojo.entity.User;
@Repository
@Mapper
public interface UserMapper {
    @Select("select * from user where user_name=#{userName} and password=#{password} ")
    int selectUser(User user);
    Page<BookPageQueryVO> queryPage(BookQueryPageDTO bookQueryPageDTO);

    int loan(BookLoanDTO bookLoanDTO);
    @Update("update book set status=0,borrower_name=null,return_date=#{returnDate} where book_name=#{bookName};")
    int returnBook(Book book);

    int selectBookStatus(BookLoanDTO bookLoanDTO);
}
