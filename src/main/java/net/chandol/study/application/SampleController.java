package net.chandol.study.application;

import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping("user")
    public String user() {
        return "pages/user";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("admin")
    public String admin() {
        return "pages/admin";
    }

}
