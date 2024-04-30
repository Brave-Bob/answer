package yqh.Service;

import yqh.pojo.DTO.BookLoanDTO;
import yqh.pojo.DTO.BookQueryPageDTO;
import yqh.pojo.entity.Book;
import yqh.pojo.entity.User;
import yqh.utils.PageResult;

public interface UserService {
    public String login(User user);
    public PageResult queryPageService(BookQueryPageDTO bookQueryPageDTO);

    String loanService(BookLoanDTO bookLoanDTO);

    String returnBookService(Book book);
}
