package org.mentor.spring.controller;

import org.mentor.spring.service.UserService;
import org.mentor.spring.service.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private UserService userService = new UserServiceImpl();

    @RequestMapping (value = "/", method = RequestMethod.GET)
    public ModelAndView  userForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tableserv");
        return modelAndView;
    }
}
