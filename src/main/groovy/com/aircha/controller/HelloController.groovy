package com.aircha.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

/**
 * Created by 정현 on 2016-10-09.
 */
@Controller
class HelloController {

    @RequestMapping("/hello")
    public String hello(@RequestParam(defaultValue = "aircha") String userName, Model model) {
        model.addAttribute("message", "Hello " + userName)
        return "hello"
    }
}
