package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo") // @RequestMapping(value = "/todo")와 같은 의미. 해당 경로의 요청을 지정하기 위해 사용
@Log4j2
public class TodoController {

    @RequestMapping("/list") //  @RequestMapping(value = "/list") 와 같은 의미. 최종 경로는 '/todo/list'
    public void list(){
        log.info("todo list......");
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

        return "redirect:/todo/list";
    }
}
