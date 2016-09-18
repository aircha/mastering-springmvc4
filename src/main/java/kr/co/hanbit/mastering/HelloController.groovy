package kr.co.hanbit.mastering

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by 정현 on 2016-09-18.
 */
@Controller
class HelloController {
    @RequestMapping
    @ResponseBody
    String hello() {
        return "Hello, world!"
    }
}
