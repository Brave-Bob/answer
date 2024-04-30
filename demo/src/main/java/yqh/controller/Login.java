package yqh.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import yqh.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import yqh.pojo.DTO.BookLoanDTO;
import yqh.pojo.DTO.BookQueryPageDTO;
import yqh.pojo.entity.Book;
import yqh.pojo.entity.User;
import yqh.utils.PageResult;

@RequestMapping("/borrowBooks/")
@RestController
@Slf4j
//@Api(tags = "所有接口")
public class Login {
    @Autowired
    private UserService userService;
    //@ApiOperation("登录接口")
    @PostMapping(value = "login" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String loginController( @RequestBody User user){
        log.info("参数:{},{}",user.getUserName(),user.getPassword());
        return userService.login(user);
    }
    //@ApiOperation("查询借阅信息的接口")
    @PostMapping
    public PageResult queryController(@RequestBody BookQueryPageDTO bookQueryPageDTO){
        return userService.queryPageService(bookQueryPageDTO);
    }
    @GetMapping("loan")
    public String loanController(BookLoanDTO bookLoanDTO){
       return userService.loanService(bookLoanDTO);
    }
    @GetMapping("return")
    public String returnBookController(Book book){
       return userService.returnBookService(book);
    }

}
