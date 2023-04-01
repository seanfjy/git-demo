package com.fanstudy.tlf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/expression")
    public String exp(Model model){

        model.addAttribute("name","吾问无为谓");
        model.addAttribute("address","八大发送扥");
        return "exp";
    }

    @GetMapping("/link")
    public String link(Integer id, String name,Model model){
        model.addAttribute("id",id);
        model.addAttribute("myname", name);
        return "link";
    }
}
