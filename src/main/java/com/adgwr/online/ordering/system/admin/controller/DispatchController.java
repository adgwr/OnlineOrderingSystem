package com.adgwr.online.ordering.system.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 */
@Controller
public class DispatchController {

    @RequestMapping(value = "/pcHomepage")
    public String pcHomepage(){
        return "pcHomepage";
    }

}
