package net.chandol.study.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

    @RequestMapping("")
    public String index() {
        return "pages/index";
    }

    @RequestMapping("/anonymous")
    public String anonymous() {
        return "pages/anonymous";
    }

    @RequestMapping("user")
    public String user() {
        return "pages/user";
    }

    @RequestMapping("admin")
    public String admin() {
        return "pages/admin";
    }

}
