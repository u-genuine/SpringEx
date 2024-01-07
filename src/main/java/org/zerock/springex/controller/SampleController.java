package org.zerock.springex.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;

import java.time.LocalDate;

@Controller // 해당 클래스가 스프링 MVC에서 컨트롤러 역할을 한다는 것을 의미 + 스프링의 빈으로 처리됨
@Log4j2
public class SampleController {

    @GetMapping("/hello")
    public void hello(){
        log.info("hello........");
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age){
        log.info("ex1.....");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex2")
    //@RequestParam은 defaultValue 속성으로 기본값을 지정할 수 있다.
    public void ex2(@RequestParam(name = "name", defaultValue = "AAA") String name, @RequestParam(name = "age", defaultValue = "20") int age){
        log.info("ex2.......");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate){
        log.info("ex3......");
        log.info("dueDate: " + dueDate);
    }

    @GetMapping("/ex4")
    public void ex4(Model model){

        log.info("-----------------------");

        //Model에서는 addAttribute() 메소드를 이용해서 뷰에 전달할 '이름'과 '값(객체)'를 지정할 수 있다.
        model.addAttribute("message", "Hello World");
    }

    @GetMapping("/ex4_1")
    // 파라미터(todoDTO)가 getter/setter를 이용하는 Java Beans 형식의 사용자 정의 클래스 -> 자동으로 화면까지 객체를 전달함
    // addAttribute() 메소드를 사용하지 않아도 JSP에서 ${todoDTO}로 받을 수 있다.
    // 자동으로 생성되는 변수명은 todoDTO인데 변경하고싶은 경우에 @ModelAttribute() 적용하기 -> JSP에서는 ${dto}
    public void ex4Extra(@ModelAttribute("dto") TodoDTO todoDTO, Model model){

        log.info(todoDTO);
    }

    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes){

        //RedirectAttributes의 addAttribute(키, 값) 메소드는 리다이렉트할 때 쿼리 스트링이 되는 값을 지정
        redirectAttributes.addAttribute("name", "ABC");

        //RedirectAttributes의 addFlashAttribute(키, 값) 메소드는 일회용으로만 데이터를 전달하고 삭제되는 값을 지정
        redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/ex6";
    }

    @GetMapping("/ex6")
    public void ex6(){

    }

    @GetMapping("/ex7")
    public void ex7(String p1, int p2){
        log.info("p1: "+p1);
        log.info("p2: "+p2);
    }
}
