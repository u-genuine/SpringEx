package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.springex.dto.TodoDTO;

@Controller
@RequestMapping("/todo") // @RequestMapping(value = "/todo")와 같은 의미. 해당 경로의 요청을 지정하기 위해 사용
@Log4j2
public class TodoController {

    @RequestMapping("/list") //  @RequestMapping(value = "/list") 와 같은 의미. 최종 경로는 '/todo/list'
    public void list(){
        log.info("todo list......");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register(){
        log.info("todo register.......");
    }

    @PostMapping("/register")
    public void registerPost(TodoDTO todoDTO){
        log.info("POST todo register.....");
        log.info(todoDTO);
    }
}
