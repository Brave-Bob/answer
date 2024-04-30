package yqh.Service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import yqh.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import yqh.mapper.UserMapper;
import yqh.pojo.DTO.BookLoanDTO;
import yqh.pojo.DTO.BookQueryPageDTO;
import yqh.pojo.VO.BookPageQueryVO;
import yqh.pojo.entity.Book;
import yqh.pojo.entity.User;
import yqh.utils.PageResult;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public PageResult queryPageService(BookQueryPageDTO bookQueryPageDTO) {
        PageHelper.startPage(bookQueryPageDTO.getPageSize(), bookQueryPageDTO.getPagination());
        Page<BookPageQueryVO> books=userMapper.queryPage(bookQueryPageDTO);
        long total =books.getTotal();
        List<BookPageQueryVO> records=books.getResult();
        return  new PageResult(total,records);
    }

    @Override
    public String returnBookService(Book book) {
        book.setReturnDate(LocalDateTime.now());
        if (userMapper.returnBook(book)==1)
            return "归还成功";
        return "归还失败,请确认输入是否正确";

    }

    @Override
    public String loanService(BookLoanDTO bookLoanDTO) {
        if (userMapper.selectBookStatus(bookLoanDTO)==0){ // 先查看书的状态
            bookLoanDTO.setLoanDate(LocalDateTime.now());
            userMapper.loan(bookLoanDTO);
        }else
            return "该书被人借走了你不能借";
        return "借书成功";
    }

    @Override
    public String login(User user) {
        return (userMapper.selectUser(user)==1) ? "登陆成功":"账号或密码输入错误，请重试！";
    }
}
