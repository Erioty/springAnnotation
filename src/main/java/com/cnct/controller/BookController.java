package com.cnct.controller;

import com.cnct.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 声明当前类为控制器类
public class BookController {

    @Autowired
    private BookService bookService;
}
