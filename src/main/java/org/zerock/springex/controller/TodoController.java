package org.zerock.springex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.service.TodoService;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo") // @RequestMapping(value = "/todo")와 같은 의미. 해당 경로의 요청을 지정하기 위해 사용
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @RequestMapping("/list") //  @RequestMapping(value = "/list") 와 같은 의미. 최종 경로는 '/todo/list'
    public void list(Model model){

        log.info("todo list......");

        //model에 "dtoList"라는 이름으로 목록 데이터를 담았기 때문에 JSP에서는 JSTL을 이용해 목록 출력
        model.addAttribute("dtoList", todoService.getAll());
    }

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public void register(){
//        log.info("todo register.......");
//    }
//
//    @PostMapping("/register")
//    public void registerPost(TodoDTO todoDTO){
//        log.info("POST todo register.....");
//        log.info(todoDTO);
//    }

    @GetMapping("/register")
    public void registerGET(){
        log.info("GET todo register.......");
    }

    @PostMapping("/register")
    public String registerPOST(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        log.info("POST todo register......");

        if(bindingResult.hasErrors()){
            log.info("has errors........");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        log.info(todoDTO);

        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }

    @GetMapping("/read")
    public void read(Long tno, Model model){

        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);

        model.addAttribute("dto", todoDTO);
    }
}
